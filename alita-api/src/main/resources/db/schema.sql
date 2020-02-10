DROP TABLE IF EXISTS alita_data;

CREATE TABLE alita_data (
	id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	longitude BIGINT(20) NOT NULL DEFAULT '0' COMMENT '经度',
	latitude BIGINT(20) NOT NULL DEFAULT '0' COMMENT '纬度',
	is_deleted TINYINT(1) NOT NULL DEFAULT '0' COMMENT '1-已删除 0-未删除',
	gmt_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'
	PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='数据表';

DROP TABLE IF EXISTS alita_config;

CREATE TABLE alita_config (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(255) not null default '' comment '接口url',
  `key` varchar(255) not null default '' comment '字段名称',
  `value` varchar(255) not null default '' comment '字段中文展示',
  `status` tinyint(1) not null default '0' comment '是否显示 0-不展示 1-展示',
  `view` varchar(255) not null default '' comment '字段中文',
  `order` tinyint(1) not null default '0' comment '字段顺序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配置表';


