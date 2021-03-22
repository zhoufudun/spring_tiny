

CREATE TABLE `lz_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint(2) DEFAULT '0',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(64) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公益口罩';



INSERT INTO `lz_user` (`id`, `is_delete`, `gmt_create`, `gmt_modified`, `username`, `password`, `real_name`, `manager_id`)
VALUES
	(456,0,'2020-05-08 10:33:57','2020-05-08 10:33:57','123xxxxxxxxxxxxxxxx','123456','小瞿',1),
	(457,0,'2020-05-08 15:36:30','2020-05-08 15:36:30','456xxxxxxxxxxxxxxxxxxxx','123456','小敏',1),
	(458,0,'2020-05-08 15:37:18','2020-05-08 15:37:18','789xxxxxxxx','123456','爸',1),
	(459,0,'2020-05-08 15:38:21','2020-05-08 15:38:21','19884189046','123456','妈',1),
	(460,0,'2020-06-29 13:04:58','2020-06-29 13:04:58','198841890x46','12345x6','妈1',1),
	(461,0,'2020-06-30 15:20:24','2020-06-30 15:20:24','zhangsan','1239832','瞿贻晓',1);

