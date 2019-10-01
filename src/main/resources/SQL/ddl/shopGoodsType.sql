CREATE TABLE `shopgoodstype` (
  `goodsTypeId` int(3) NOT NULL auto_increment,
  `goodsTypeName` varchar(50) default NULL,
  `parentId` int(3) default NULL,
  PRIMARY KEY  (`goodsTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;