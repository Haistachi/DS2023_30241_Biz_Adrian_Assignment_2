
insert into device (id, address, consumption, description, person)
values (1, 'ma doare', 3, 'telefon', 2),
       (2, 'str Drum', 1, 'ceas', 2)
    ON CONFLICT (id)
DO NOTHING;