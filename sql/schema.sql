CREATE TABLE `user` (
                      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                      `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
                      `account` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
                      `password` varchar(512) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
                      `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '状态（0：删除，1：申请中，2：激活，3：冻结）',
                      PRIMARY KEY (`id`),
                      UNIQUE KEY `account_UNIQUE` (`account`),
                      UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4699 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin PACK_KEYS=1 COMMENT='系统用户';