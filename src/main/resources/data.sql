
insert into "user" (id, role, user_password, username)
values (decode('77779b97696a4ff8a576cf53bb4e04e4','hex'), 'admin', 'Crusader2', 'Haistachi'),
       (decode('ee2d6d67c45b4745a9f712e7948ef8d9','hex'), 'user', '123', 'User'),
       (decode('3df1207bf91e4f6ca759b04ea772866d','hex'), 'user', 'minune', 'Alin'),
       (decode('188e6ba1edbf42828cb39ab4fd4514a6','hex'), 'user', 'salam', 'Costel'),
       (decode('8abc93a57db84ce996c889390307504d','hex'), 'user', '123', 'Patme'),
       (decode('cb44f8c8e4614d40a7c7dbda859ac565','hex'), 'user', '123', 'Amidala'),
       (decode('75a33ef4cdf449ffac5155b391bcec1a','hex'), 'user', '123', 'User2'),
       (decode('6aa58fe4a7d246f690a4a0ed1ec420f5','hex'), 'user', 'user', 'Parola'),
       (decode('a8d8f4835d72414eba9133fd0c420e51','hex'), 'user', '123', 'User3'),
       (decode('ed6b97c513f94208a8d6ab59d67618e7','hex'), 'user', '123', 'Pag'),
       (decode('670ebe053de647d9b2baf1968a832d11','hex'), 'user', '123', 'Noua');

insert into device (id, address, consumption, description, person)
values (decode('4c26042e096f4b9b80054b76cb5892aa','hex'), 'ma doare', 3, 'telefon', 'ee2d6d67-c45b-4745-a9f7-12e7948ef8d9'),
       (decode('26fac0d3329f4d549c309f2ab8c75fdf','hex'), 'str Drum', 1, 'ceas', 'ee2d6d67-c45b-4745-a9f7-12e7948ef8d9');

insert into active (id, consumption, device, "timestamp")
values (decode('7f5b505ee0cc411e9fe9d0e4c6787113','hex'), 2, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 08:00:00'),
       (decode('1a7ac7afc5994157a84884a2352e8907','hex'), 4, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 09:00:00'),
       (decode('183239b837a444fea81c001c9dd42c87','hex'), 8, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 10:00:00'),
       (decode('f5d3e85b22cc4a328adf31eb45499592','hex'), 10, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 11:00:00'),
       (decode('77fadbe7261147c4b864c4a8602e3987','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 00:00:00'),
       (decode('400d73fe516046cfbf4a97420c24a6b1','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 01:00:00'),
       (decode('8024b5df800c42a6ab119320093af20f','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 02:00:00'),
       (decode('b85dca5577e54658beae07bae3b4c474','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 03:00:00'),
       (decode('041fed5d84f2429795abb4528759a112','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 04:00:00'),
       (decode('df63fd46f06744e9a8488cd7c1f0b4ac','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 05:00:00'),
       (decode('8da4d2a49afd4000b7c9dd75831c45fd','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 06:00:00'),
       (decode('f3255d3c30104b789a35100d1b262b1f','hex'), 0, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 07:00:00'),
       (decode('b0c9396ec44e42f180a74b8e8ac49345','hex'), 10, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 12:00:00'),
       (decode('f359e5fe63294738a8c12810e599a2ab','hex'), 11, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 13:00:00'),
       (decode('69ec20fd962341b195d26d3cf6e4f3f1','hex'), 12, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 14:00:00'),
       (decode('b362b5bb470c412ba0e46ead7520caf3','hex'), 13, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 15:00:00'),
       (decode('4a17686044df48e6b66ef281bfaacbc5','hex'), 14, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 16:00:00'),
       (decode('4d8e3ee26beb4a079062ddb2ebadabd8','hex'), 15, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 17:00:00'),
       (decode('b357839a1b964919a65c053ed683f634','hex'), 16, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 18:00:00'),
       (decode('c9f301d8031a454aaff79dc93a0c64ba','hex'), 17, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 19:00:00'),
       (decode('0a60fe1db33f4a2c94e0568371127414','hex'), 18, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 20:00:00'),
       (decode('66f518c0176741dfb512fb86136b9e27','hex'), 19, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 21:00:00'),
       (decode('0a26b3e44169457b994003525f3ab4cd','hex'), 20, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 22:00:00'),
       (decode('201c858a53f145448bbb768d7a67d09d','hex'), 21, '4c26042e-096f-4b9b-8005-4b76cb5892aa', '2022-12-17 23:00:00');