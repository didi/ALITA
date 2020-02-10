#!/usr/bin/env bash
set -x

SCRIPT="${BASH_SOURCE-$0}"
SCRIPT_DIR="$(dirname ${SCRIPT})"
SCRIPT_DIR="$(cd ${SCRIPT_DIR}; pwd)"

echo "开始构建"
mvn clean package -U -Dmaven.test.skip=true;
TARGET_DIR="$SCRIPT_DIR/alita-api/target"
OUTPUT_DIR="$SCRIPT_DIR/output"
mkdir -p ${OUTPUT_DIR}; rm -rf ${OUTPUT_DIR}/*;
cp -r ${TARGET_DIR}/alita.jar ${OUTPUT_DIR}/;
cp ${SCRIPT_DIR}/control.sh ${OUTPUT_DIR}/;

if [ ! "$(ls -v ${OUTPUT_DIR})" ] ; then
echo "构建失败"
exit 1
fi
echo "构建成功"
exit 0