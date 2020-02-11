# ALITA
ALITA is a layer-based data analysis tool.

# Overview

ALITA（A Layered Instrument To Analyze）is a tool which is used to display data based on layer analysis, we through a lot of business requirements precipitation abstract generalization of the "point", "line", "plane" three kind of data model, perfect integrate the map of point, line and plane design elements, design and packaging the front-end and back-end general modular components, achieve rapid build maps.
                                      
ALITA aims to build a one-stop platform for geographic information visualization and analysis, which can display a large number of geographic information data of different dimensions such as points, lines and planes, quickly visualize the data and conduct statistical analysis, and produce relevant heat maps, grid maps and statistical distribution maps for users to analyze and make decisions. At present, it has been widely used in many offline operation scenarios of xiaoju to meet the needs of rapid iteration of products with booming demand under the rapid growth of business, bringing great business value. 

# Feature

• agile development, fast iteration, stable security, easy to use

• components can be configured flexibly

• support massive data spatiotemporal aggregation, stack analysis, multi-dimensional display

• tool set, strong practicality, multi - terminal unity

• data-driven view, full and complete solution

# Architecture

## Environment

•	**Language** : Java 8+、JAVASCRIPT

•	**IDE(Java)** : IDEA/Eclipse installs the Lombok plug-in、VSCode

•	**Dependency management** : Maven、npm

•	**Database** : MySQL5.7+

## Back end

•	**Base framework** : Spring Boot 2.2.0.RELEASE

•	**ORM framework** : Mybatis-Plus 3.3.0

•	**Log** : logback

## Front end

•	**Language** : React

•	**Component** : antd

•	**Framework** : dva

•	**Scaffold** : create-react-app

•	**Bundler Tool** : webpack

# Development

• Back end

```
git clone git@github.com:didi/ALITA.git
cd ALITA
sh build.sh
sh control.sh
```

• Front end

```
git clone git@github.com:didi/ALITA-UI.git
cd ALITA-UI
sudo npm install -g cnpm --registry=https://registry.npm.taobao.org
cnpm i
npm start
```

# Contributing

Any contribution is welcome. All issues and pull requests are highly appreciated! For more details, please refer to  [the contribution guide](CONTRIBUTING.md).

# Community

**dingtalk : 30067799**

![dingtalk](ALITA_Chat.jpg)

# License

<img alt="Apache-2.0 license" src="https://lucene.apache.org/images/mantle-power.png" width="128">

ALITA is licensed under the terms of the Apache license. See [LICENSE ](LICENSE)for more information.
