
insert into "user" (id, role, user_password, username)
values ('1', 'admin', 'Crusader2', 'Haistachi'),
       ('2', 'user', '123', 'User'),
       ('3', 'user', 'minune', 'Alin'),
       ('4', 'user', 'salam', 'Costel'),
       ('5', 'user', '123', 'Patme'),
       ('6', 'user', '123', 'Amidala'),
       ('7', 'user', '123', 'User2'),
       ('8', 'user', 'user', 'Parola'),
       ('9', 'user', '123', 'User3'),
       ('10', 'user', '123', 'Pag'),
       ('11', 'user', '123', 'Noua')
    ON CONFLICT (id)
DO NOTHING;