CREATE TABLE `user`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `role`     int                                                           DEFAULT NULL COMMENT '角色  1学生 2管理员',
    `sex`      varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci   DEFAULT NULL,
    `phone`    char(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf8mb3
  ROW_FORMAT = COMPACT

