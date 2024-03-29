--liquibase formatted sql

--changeset user:1
INSERT INTO PERSON (id,nume, prenume, cnp, data_nasterii, adresa, telefon, email)
VALUES
    (1,'Smith', 'John', '1980101234567', '1980-01-01', '123 Main St, Anytown', '123-456-7890', 'john.smith@example.com'),
    (2,	'Johnson',	'Mary',	'1990123456789',	'1990-12-31',	'456 Elm St, Otherville',	'555-123-4567',	'mary.johnson@example.com'),
    (3,	'Williams',	'David',	'1985050909876',	'1985-05-09',	'789 Oak Ave, Anothercity',	'987-654-3210',	'david.williams@example.com'),
    (4,	'Brown',	'Sarah',	'1997112345678',	'1997-11-23',	'321 Pine St, Somewhere',	'111-222-3333',	'sarah.brown@example.com'),
    (5,	'Jones',	'Michael',	'1978090123456',	'1978-09-01',	'567 Maple Dr, Hometown',	'444-555-6666',	'michael.jones@example.com'),
    (6,	'Davis',	'Jennifer',	'1983080765432',	'1983-08-07',	'890 Oak Ln, Cityville',	'777-888-9999',	'jennifer.davis@example.com'),
    (7,	'Miller',	'Christopher', '1995022812345',	'1995-02-28',	'246 Cedar Rd, Villagetown',	'666-777-8888',	'christopher.miller@example.com'),
    (8,	'Wilson',	'Jessica', '1987100912345',	'1987-10-09',	'369 Pine Ave, Townsville',	'222-333-4444',	'jessica.wilson@example.com'),
    (9,	'Anderson',	'Matthew', '1990011123456',	'1990-01-11',	'135 Elm Ct, Suburbia',	'999-000-1111',	'matthew.anderson@example.com'),
    (10,'Thomas',	'Amanda', '1982112334567',	'1982-11-23',	'789 Oak St, Countryside',	'333-444-5555',	'amanda.thomas@example.com'),
    (11,'Jackson',	'Andrew', '1994041545678',	'1994-04-15',	'456 Maple Dr, Villatown',	'888-999-0000',	'andrew.jackson@example.com'),
    (12,'White',	'Emily', '1988060923456',	'1988-06-09',	'246 Pine Ln, Outskirts',	'111-222-3333',	'emily.white@example.com'),
    (13,'Harris',	'Daniel', '1998061234567',	'1998-06-12',	'369 Oak Rd, Ruralville',	'444-555-6666',	'daniel.harris@example.com'),
    (14,'Martin',	'Olivia', '1985091512345',	'1985-09-15',	'789 Elm Ave, Metropolis',	'777-888-9999',	'olivia.martin@example.com'),
    (15,'Thompson',	'Ethan', '1997121734567',	'1997-12-17',	'123 Pine St, Urbanville',	'222-333-4444',	'ethan.thompson@example.com'),
    (16,'Garcia',	'Sophia', '1983081934567',	'1983-08-19',	'456 Oak Dr, Downtown',	'999-000-1111',	'sophia.garcia@example.com'),
    (17,'Martinez',	'Noah',	'1991052123456',	'1991-05-21',	'789 Elm Ln, Suburbia',	'333-444-5555',	'noah.martinez@example.com'),
    (18,'Robinson',	'Isabella',	'1986042323456',	'1986-04-23',	'246 Pine Rd, Cityville',	'888-999-0000',	'isabella.robinson@example.com'),
    (19,'Clark',	'Benjamin',	'1999062545678',	'1999-06-25',	'369 Oak St, Countryside',	'111-222-3333',	'benjamin.clark@example.com'),
    (20,'Rodriguez',	'Mia',	'1984072723456',	'1984-07-27',	'123 Maple Dr, Townsville',	'444-555-6666',	'mia.rodriguez@example.com'),
    (21,'Lewis',	'James',	'1997072934567',	'1997-07-29',	'456 Pine Ave, Villatown',	'777-888-9999',	'james.lewis@example.com'),
    (22,'Lee',	'Abigail',	'1988113034567',	'1988-11-30',	'789 Oak Ln, Cityville',	'222-333-4444',	'abigail.lee@example.com'),
    (23,'Walker',	'Alexander',	'1994093234567',	'1994-09-23',	'246 Elm Rd, Countryside',	'999-000-1111',	'alexander.walker@example.com'),
    (24,'Hall',	'Charlotte',	'1987063434567',	'1987-06-03',	'369 Maple Ct, Suburbia',	'333-444-5555',	'charlotte.hall@example.com'),
    (25,'Allen',	'Harper',	'1998033634567',	'1998-03-06',	'123 Pine Dr, Villagetown',	'888-999-0000',	'harper.allen@example.com'),
    (26,'Young',	'Daniel',	'1983043834567',	'1983-04-08',	'456 Oak Ave, Anothercity',	'111-222-3333',	'daniel.young@example.com'),
    (27,'Hernandez',	'Evelyn',	'1995084034567',	'1995-08-04',	'789 Elm St, Somewhere',	'444-555-6666',	'evelyn.hernandez@example.com'),
    (28,'King',	'Amelia',	'1986014234567',	'1986-01-14',	'246 Pine Dr, Hometown',	'777-888-9999',	'amelia.king@example.com'),
    (29,'Wright',	'Michael',	'1993054434567',	'1993-05-04',	'369 Oak Ave, Anytown',	'222-333-4444',	'michael.wright@example.com'),
    (30,'Lopez',	'Sofia',	'1988094634567',	'1988-09-04',	'123 Elm Ct, Otherville',	'999-000-1111',	'sofia.lopez@example.com'),
    (31,'Hill',	'Aiden',	'1992104834567',	'1992-10-04',	'456 Pine Rd, Anothercity',	'333-444-5555',	'aiden.hill@example.com'),
    (32,'Scott',	'Victoria',	'1984035034567',	'1984-03-05',	'789 Oak Ave, Outskirts',	'888-999-0000',	'victoria.scott@example.com'),
    (33,'Green',	'Gabriella',	'1999115234567',	'1999-11-05',	'246 Maple Dr, Metropolis',	'111-222-3333',	'gabriella.green@example.com'),
    (34,'Adams',	'Henry',	'1983095434567',	'1983-09-05',	'369 Elm Ln, Urbanville',	'444-555-6666',	'henry.adams@example.com'),
    (35,'Baker',	'Madison',	'1994075634567',	'1994-07-05',	'123 Pine St, Villagetown',	'777-888-9999',	'madison.baker@example.com'),
    (36,'Gonzalez',	'Samuel',	'1989045834567',	'1989-04-05',	'456 Oak Ave, Cityville',	'222-333-4444',	'samuel.gonzalez@example.com'),
    (37,'Nelson',	'Lily',	'1996056034567',	'1996-05-06',	'789 Elm Dr, Suburbia',	'999-000-1111',	'lily.nelson@example.com'),
    (38,'Carter',	'Ella',	'1987066234567',	'1987-06-06',	'246 Maple Rd, Townsville',	'333-444-5555',	'ella.carter@example.com'),
    (39,'Mitchell',	'Joseph',	'1998056434567',	'1998-05-06',	'369 Pine Ave, Countryside',	'888-999-0000',	'joseph.mitchell@example.com'),
    (40,'Perez',	'Avery',	'1987076634567',	'1987-07-06',	'123 Oak Dr, Villatown',	'111-222-3333',	'avery.perez@example.com'),
    (41,'Roberts',	'Scarlett',	'1999066834567',	'1999-06-06',	'456 Pine Ln, Cityville',	'444-555-6666',	'scarlett.roberts@example.com'),
    (42,'Turner',	'Dylan',	'1985087034567',	'1985-08-07',	'789 Elm Rd, Countryside',	'777-888-9999',	'dylan.turner@example.com'),
    (43,'Phillips',	'Zoey',	'1998107234567',	'1998-10-07',	'246 Maple Ave, Hometown',	'222-333-4444',	'zoey.phillips@example.com'),
    (44,'Campbell',	'Wyatt',	'1983127434567',	'1983-12-07',	'369 Oak St, Anothercity',	'999-000-1111',	'wyatt.campbell@example.com'),
    (45,'Parker',	'Penelope',	'1995077634567',	'1995-07-07',	'123 Pine Ct, Metropolis',	'333-444-5555',	'penelope.parker@example.com'),
    (46,'Evans',	'Layla',	'1988097834567',	'1988-09-07',	'456 Oak Dr, Otherville',	'888-999-0000',	'layla.evans@example.com'),
    (47,'Edwards',	'Oliver',	'1994088034567',	'1994-08-08',	'789 Elm Ave, Anothercity',	'111-222-3333',	'oliver.edwards@example.com'),
    (48,'Collins',	'Chloe',	'1988038234567',	'1988-03-08',	'246 Maple Ln, Villagetown',	'444-555-6666',	'chloe.collins@example.com'),
    (49,'Stewart',	'Emma',	'1998038434567',	'1998-03-08',	'369 Oak Dr, Outskirts',	'777-888-9999',	'emma.stewart@example.com'),
    (50,'Sanchez',	'Sebastian',	'1986048634567',	'1986-04-08',	'123 Pine Ave, Urbanville',	'222-333-4444',	'sebastian.sanchez@example.com'),
    (51,'Morris',	'Natalie',	'1991068834567',	'1991-06-08',	'456 Oak Rd, Suburbia',	'999-000-1111',	'natalie.morris@example.com'),
    (52,'Murphy',	'Riley',	'1983029034567',	'1983-02-09',	'789 Elm Ct, Cityville',	'333-444-5555',	'riley.murphy@example.com'),
    (53,'Rogers',	'Stella',	'1999089234567',	'1999-08-09',	'246 Maple Rd, Villatown',	'888-999-0000',	'stella.rogers@example.com'),
    (54,'Reed',	'Lincoln',	'1985099434567',	'1985-09-09',	'369 Pine Dr, Metropolis',	'111-222-3333',	'lincoln.reed@example.com'),
    (55,'Cook',	'Hazel',	'1994069634567',	'1994-06-09',	'123 Oak Ave, Anytown',	'444-555-6666',	'hazel.cook@example.com'),
    (56,'Morgan',	'Samantha',	'1987019834567',	'1987-01-09',	'456 Pine Ln, Hometown',	'777-888-9999',	'samantha.morgan@example.com'),
    (57,'Bell',	'Isaac',	'1996120034567',	'1996-12-10',	'789 Oak Dr, Otherville',	'222-333-4444',	'isaac.bell@example.com'),
    (58,'Murphy',	'Brooklyn',	'1983070234567',	'1983-07-02',	'246 Elm Ave, Anothercity',	'999-000-1111',	'brooklyn.murphy@example.com'),
    (59,'Torres',	'Audrey',	'1999110434567',	'1999-11-04',	'369 Pine Rd, Countryside',	'333-444-5555',	'audrey.torres@example.com'),
    (60,'Peterson',	'Leo',	'1989120634567',	'1989-12-06',	'123 Oak Ln, Villagetown',	'888-999-0000',	'leo.peterson@example.com'),
    (61,'Gray',	'Zoe',	'1992100834567',	'1992-10-08',	'456 Pine Ave, Cityville',	'111-222-3333',	'zoe.gray@example.com'),
    (62,'Ramirez',	'Lincoln',	'1986081034567',	'1986-08-10',	'789 Elm Dr, Metropolis',	'444-555-6666',	'lincoln.ramirez@example.com'),
    (63,'James',	'Mila',	'1999061234567',	'1999-06-12',	'246 Oak Ct, Villagetown',	'777-888-9999',	'mila.james@example.com'),
    (64,'Watson',	'Eli',	'1986121434567',	'1986-12-14',	'369 Maple Rd, Urbanville',	'222-333-4444',	'eli.watson@example.com'),
    (65,'Brooks',	'Aria',	'1998061634567',	'1998-06-16',	'123 Elm Dr, Suburbia',	'999-000-1111',	'aria.brooks@example.com'),
    (66,'Kelly',	'Hannah',	'1985081834567',	'1985-08-18',	'456 Pine Ln, Cityville',	'333-444-5555',	'hannah.kelly@example.com'),
    (67,'Sanders',	'Nathaniel',	'1993072034567',	'1993-07-20',	'789 Oak Ave, Outskirts',	'888-999-0000',	'nathaniel.sanders@example.com'),
    (68,'Price',	'Addison',	'1984072234567',	'1984-07-22',	'246 Elm Dr, Townsville',	'111-222-3333',	'addison.price@example.com'),
    (69,'Bennett',	'Ellie',	'1995092434567',	'1995-09-24',	'369 Maple Ln, Villagetown',	'444-555-6666',	'ellie.bennett@example.com'),
    (70,'Wood',	'Nolan',	'1985122634567',	'1985-12-26',	'123 Oak Rd, Otherville',	'777-888-9999',	'nolan.wood@example.com'),
    (71,'Barnes',	'Maya',	'1997062834567',	'1997-06-28',	'456 Pine Ln, Anothercity',	'222-333-4444',	'maya.barnes@example.com'),
    (72,'Ross',	'Lillian',	'1988053034567',	'1988-05-30',	'789 Elm Ave, Hometown',	'999-000-1111',	'lillian.ross@example.com'),
    (73,'Henderson',	'Gavin',	'1995093234567',	'1995-09-28',	'246 Oak Ct, Anothercity',	'333-444-5555',	'gavin.henderson@example.com'),
    (74,'Coleman',	'Leah',	'1986083434567',	'1986-08-24',	'369 Pine Dr, Otherville',	'888-999-0000',	'leah.coleman@example.com'),
    (75,'Jenkins',	'Connor',	'1993093634567',	'1993-09-16',	'123 Elm Rd, Cityville',	'111-222-3333',	'connor.jenkins@example.com'),
    (76,'Perry',	'Hazel',	'1988043834567',	'1988-04-28',	'456 Oak Ln, Villagetown',	'444-555-6666',	'hazel.perry@example.com'),
    (77,'Powell',	'Eliana',	'1996074034567',	'1996-07-10',	'789 Elm Ave, Metropolis',	'777-888-9999',	'eliana.powell@example.com'),
    (78,'Long',	'Adam',	'1986114234567',	'1986-11-15',	'246 Pine Rd, Urbanville',	'222-333-4444',	'adam.long@example.com'),
    (79,'Hughes',	'Naomi',	'1999124434567',	'1999-12-20',	'369 Oak Dr, Hometown',	'999-000-1111',	'naomi.hughes@example.com'),
    (80,'Flores',	'Maxwell',	'1988034634567',	'1988-03-21',	'123 Pine Ln, Anothercity',	'333-444-5555',	'maxwell.flores@example.com'),
    (81,'Washington',	'Lyla',	'1997084834567',	'1997-08-27',	'456 Elm Ave, Metropolis',	'888-999-0000',	'lyla.washington@example.com'),
    (82,'Butler',	'Xander',	'1987115034567',	'1987-11-30',	'789 Oak Dr, Anothercity',	'111-222-3333',	'xander.butler@example.com'),
    (83,'Simmons',	'Delilah',	'1995125234567',	'1995-12-12',	'246 Maple Rd, Otherville',	'444-555-6666',	'delilah.simmons@example.com'),
    (84,'Foster',	'Ryder',	'1984085434567',	'1984-08-04',	'369 Pine Ave, Cityville',	'777-888-9999',	'ryder.foster@example.com'),
    (85,'Gonzales',	'Annabelle',	'1999095634567',	'1999-09-03',	'123 Elm Ct, Outskirts',	'222-333-4444',	'annabelle.gonzales@example.com'),
    (86,'Bryant',	'Cole',	'1987105834567',	'1987-10-01',	'456 Oak Dr, Villagetown',	'999-000-1111',	'cole.bryant@example.com'),
    (87,'Alexander',	'Bella',	'1997126034567',	'1997-12-06',	'789 Pine Rd, Suburbia',	'333-444-5555',	'bella.alexander@example.com'),
    (88,'Russell',	'Asher',	'1988066234567',	'1988-06-06',	'246 Elm Ln, Anothercity',	'888-999-0000',	'asher.russell@example.com'),
    (89,'Griffin',	'Violet',	'1995096434567',	'1995-09-12',	'369 Pine Dr, Townsville',	'111-222-3333',	'violet.griffin@example.com'),
    (90,'Diaz',	'Damien',	'1988046634567',	'1988-04-16',	'123 Oak Ave, Hometown',	'444-555-6666',	'damien.diaz@example.com'),
    (91,'Hayes',	'Skylar',	'1991066834567',	'1991-06-18',	'456 Pine Ln, Anothercity',	'777-888-9999',	'skylar.hayes@example.com'),
    (92,'Myers',	'Hannah',	'1987127034567',	'1987-12-10',	'789 Oak Dr, Metropolis',	'222-333-4444',	'hannah.myers@example.com'),
    (93,'Ford',	'Roman',	'1991097234567',	'1991-09-12',	'246 Elm Rd, Urbanville',	'999-000-1111',	'roman.ford@example.com'),
    (94,'Hamilton',	'Piper',	'1986057434567',	'1986-05-14',	'369 Pine Ave, Hometown',	'333-444-5555',	'piper.hamilton@example.com'),
    (95,'Graham',	'Xavier',	'1995127634567',	'1995-12-26',	'123 Oak Ct, Anothercity',	'888-999-0000',	'xavier.graham@example.com'),
    (96,'Sullivan',	'Arianna',	'1987087834567',	'1987-08-30',	'456 Pine Rd, Metropolis',	'111-222-3333',	'arianna.sullivan@example.com'),
    (97,'Wallace',	'Eliana',	'1996098034567',	'1996-09-25',	'789 Elm Ln, Urbanville',	'444-555-6666',	'eliana.wallace@example.com'),
    (98,'Woods',	'Nolan',	'1985108234567',	'1985-10-22',	'246 Oak Ave, Cityville',	'777-888-9999',	'nolan.woods@example.com'),
    (99,'Cole',	'Eva',	'1997068434567',	'1997-06-21',	'369 Maple Ln, Metropolis',	'222-333-4444',	'eva.cole@example.com'),
    (100,	'Cox',	'Gabriel',	'1986088634567',	'1986-08-24',	'123 Pine Dr, Villagetown',	'999-000-1111',	'gabriel.cox@example.com')
;

--rollback ;