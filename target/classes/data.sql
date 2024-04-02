INSERT INTO type(type)
VALUES("cafe");
INSERT INTO type(type)
VALUES("restaurant");
INSERT INTO type(type)
VALUES("museum");
INSERT INTO type(type)
VALUES("hotel"),
("architecture");

INSERT into places(address, city, name, type_id, website, description)
VALUES("Uus 19", "Tallinn", "Chakra", 1, "https://www.chakra.ee/", "Chakra Restaurant offers a harmonious blend of Indian cuisine and contemporary dining in the heart of Tallinn, Estonia. With a focus on authentic flavors and innovative dishes, Chakra invites guests on a culinary journey through the vibrant tastes of India. From aromatic curries to tantalizing tandoori specialties, each dish is thoughtfully crafted to delight the senses. Experience the essence of Indian hospitality in a stylish and inviting atmosphere at Chakra Restaurant.");
INSERT into places(address, city, name, type_id, website, description)
VALUES("Valge 1", "Tallinn", "Kumu Art Museum", 3, "https://kumu.ekm.ee/en/", "Kumu Art Museum, located in Tallinn, Estonia, is a cultural gem renowned for its contemporary art collections and striking architectural design. As the largest art museum in the country, Kumu showcases both Estonian and international works, offering visitors a diverse range of artistic perspectives. From avant-garde installations to classical masterpieces, Kumu celebrates creativity in all its forms. With its modern galleries and immersive exhibitions, Kumu Art Museum invites guests to explore the dynamic world of contemporary art while appreciating Estonia's rich cultural heritage.");
INSERT into places(address, city, name, type_id, website, description)
VALUES("Vene 9", "Tallinn", "Telegraaf", 4,"https://www.marriott.com/reservation/expiredSession.mi", "The Telegraaf Hotel in Tallinn blends historic charm with modern luxury. Located near Old Town Square, it offers elegant rooms, a renowned restaurant, and a relaxing spa. Perfect for travelers seeking a memorable stay in Estonia's capital."),
("Unnamed road", "Pärnu", "Pärnu muul", 5, "https://visitparnu.com/en/the-mole-of-parnu/", "Constructed once to deepen the port and boost trade, the mole of Pärnu (often also referred to as the Jetty of Pärnu) is one of the city’s most interesting sights."),
("Nikolai 32", "Pärnu", "Supelsaksad", 1, "https://www.supelsaksad.ee/", "-"),
("Aida 3", "Pärnu", "Pärnu Muuseum", 3, "https://www.parnumuuseum.ee/", "The permanent exhibition on Pärnu Museum building provides an overview of 11 000 years of history in Pärnu County through exciting exhibits and displays that introduce the life and conditions of the various eras. In addition to permanent exhibition, the museum has a whole floor for temporary exhibitions and a plenty entertainment for the whole family");

INSERT into images(img_url, place_id)
values(
    "https://static.wixstatic.com/media/dc1665_588bce78bd724f0d96544fc63d4e189c~mv2.jpg/v1/crop/x_1126,y_0,w_4467,h_4461/fill/w_392,h_392,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/4Q0A1837.jpg", 1
),
(
    "https://file.visittallinn.ee/4x5jxm/detail-chakrav2.jpg", 1
),
(
    "https://sirp.ee/wp-content/uploads/2018/12/sirp_18_49_0032__art_r1.jpg", 2
),
(
    "https://i.err.ee/resize?type=optimize&height=1780&url=https%3A%2F%2Fs.err.ee%2Fphoto%2Fcrop%2F2011%2F05%2F23%2F73016h2aa5.jpg", 2
),
(
    "https://i0.wp.com/andershusa.com/wp-content/uploads/2021/07/telegraaf-hotel-the-most-luxurious-hotel-in-tallinn-estonia-best-accommodation-bed-room-suite-pool-tips-recommendations-guide-travel-12.jpg?ssl=1", 3
),
(
    "https://i0.wp.com/andershusa.com/wp-content/uploads/2021/07/telegraaf-hotel-the-most-luxurious-hotel-in-tallinn-estonia-best-accommodation-bed-room-suite-pool-tips-recommendations-guide-travel-7.jpg?ssl=1", 3
),

(
    "https://ivkhk-my.sharepoint.com/:i:/r/personal/kristiina_parri_ivkhk_ee/Documents/travelApp/Parnu-muul-1-1.jpg?csf=1&web=1&e=IOvZXl", 4
),
(
    "https://ivkhk-my.sharepoint.com/:i:/r/personal/kristiina_parri_ivkhk_ee/Documents/travelApp/600_400_false_false_dfcabe8fd304088fc5d53dc3ea4b8578.jpg?csf=1&web=1&e=ysKvwn", 5
),
(
    "https://www.eleven.ee/wp-content/uploads/2014/10/kohvik-supelsaksad2.jpg", 5
),
(
    "https://ivkhk-my.sharepoint.com/:i:/r/personal/kristiina_parri_ivkhk_ee/Documents/travelApp/50617286202_3cb54c1fb2_k.jpg?csf=1&web=1&e=HniFjm", 6
),
(
    "https://ivkhk-my.sharepoint.com/:i:/r/personal/kristiina_parri_ivkhk_ee/Documents/travelApp/1669293265-1307.jpg?csf=1&web=1&e=ZFiYEb", 6
);

INSERT into transport(comfort, type, firma, details)
VALUES(4, "bus", "Lux Express", "coffee, wi-fi, a/c");
INSERT into transport(comfort, type, firma)
VALUES(3, "bus", "Hansa Bus");

INSERT into guides(email, firstname, lastname, phone, bio)
VALUES("petrovguide@gmail.com", "Ivan", "Petrov", "+37245486945", "Greetings! I'm Ivan Petrov, a seasoned tour guide blending knowledge, charisma, and a love for cultural exploration. With a background in History and Anthropology, I bring a profound understanding to each destination.");
INSERT into guides(email, firstname, lastname, phone, bio)
VALUES("elenakotova@gmail.com", "Elena", "Kotova", "+37247593743", "Greetings, fellow wanderers! I'm Elena Kotova, your spirited tour guide on a journey of discovery. With a heart full of passion for travel and an insatiable curiosity for the world's wonders, I invite you to join me on an unforgettable adventure.");


INSERT into tours(guide_id, spots, free_spots, price, start, end_Date, transport_id, city, name)
VALUES(1, 25, 4, 70.99, '2024-02-24', '2024-02-25', 1, "Tallinn", "Weekend Tallinn tour"),
(2, 25, 9, 20.99, '2024-05-24', '2024-05-24', 2, "Tallinn", "Museum tour"),
(1, 25, 1, 30.00, "2024-05-03", "2024-05-03", 1, "Pärnu", "Pärnu nature&history tour");

INSERT into tour_place(tour_id, place_id)
VALUES(1, 1);
INSERT into tour_place(tour_id, place_id)
VALUES(1, 2);
INSERT into tour_place(tour_id, place_id)
VALUES(1, 3);
INSERT into tour_place(tour_id, place_id)
VALUES(2, 1);
INSERT into tour_place(tour_id, place_id)
VALUES(2, 2);
INSERT INTO tour_place(tour_id, place_id)
VALUES
    (3, (SELECT id FROM places WHERE name = 'Pärnu muul')),
    (3, (SELECT id FROM places WHERE name = 'Supelsaksad')),
    (3, (SELECT id FROM places WHERE name = 'Pärnu Muuseum'));

insert into users(role, email, username, password, avatar, bio) values('USER_ROLE', 'mariamaeva@gmail.com', 'marie', '12345', 'https://ivkhk-my.sharepoint.com/:i:/g/personal/kristiina_parri_ivkhk_ee/Ec-W9TKZC_VLtefSKnoNNLgBs8pJhW-9gS2_ECEeb4v7_g?e=8wgpwG', 'Adventurous soul with a passion for exploring the world and creating lasting memories. From bustling cityscapes to serene landscapes, I thrive on the thrill of new cultures, diverse cuisines, and the beauty of unique destinations. My journey is a tapestry of experiences, woven with curiosity, wanderlust, and a deep appreciation for the extraordinary moments that travel gifts us');
insert into users(role, email, username, password, avatar, bio) values('USER_ROLE', 'metsik@gmail.com', 'martmets', '12345', 'https://ivkhk-my.sharepoint.com/:i:/r/personal/kristiina_parri_ivkhk_ee/Documents/travelApp/images.jpg?csf=1&web=1&e=OGadmO', 'CS Student, travel enthusiast');
insert into user_tour values(1, 1);

insert into user_tour
values(1, 1);

insert into reviews(rating, tour_id, user_id, tour_comment)
values(5, 1, 1, "one of the best tours i've ever taken. the guide was very friendly and knowledgeable"),
(3, 1, 2, "tour was kinda mediocre and way too expensive, i've seen better for this price"),

(5, 2, 1, "tour was ok, price is nice"),
(3, 2, 2, "the guide was rude and didn't want to answer the questions"),

(5, 3, 1, "tour was awesome, totally worth your $$"),
(5, 3, 2, "tour was great, we've had the time of our lives");

