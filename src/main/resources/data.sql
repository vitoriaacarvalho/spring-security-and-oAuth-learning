INSERT INTO `USERS_TABLE` (`user_id`,`username`,`password`)
VALUES ('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454','vits','$2a$10$xMpP8zeBgfaI5xPB9.2rLuLOOYbK6rW128f4h5IOD13VzD3h12Zqu');

INSERT INTO `USERS_TABLE` (`user_id`,`username`,`password`)
VALUES ('d20f59a2-c9a9-4834-aabb-afb3dd851bbe','vitoria','$2a$10$xMpP8zeBgfaI5xPB9.2rLuLOOYbK6rW128f4h5IOD13VzD3h12Zqu');





INSERT INTO `roles_table` (`id`,`name`)
VALUES ('02d81d6d-4163-4abc-a80c-851b59e92176','ROLE_ADMIN');

INSERT INTO `roles_table` (`id`,`name`)
VALUES ('b5baa1a8-6968-443e-a4a3-a5c5e986ed0c','ROLE_USER');





INSERT INTO `TB_USERS_ROLES` (`user_id`,`role_id`)
VALUES('d20f59a2-c9a9-4834-aabb-afb3dd851bbe','02d81d6d-4163-4abc-a80c-851b59e92176');

INSERT INTO `TB_USERS_ROLES` (`user_id`,`role_id`)
VALUES('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454','b5baa1a8-6968-443e-a4a3-a5c5e986ed0c');