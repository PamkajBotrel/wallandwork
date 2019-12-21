
INSERT INTO public.member(group_id, name, email) VALUES (0, 'Pamkaj','a@a.a');
INSERT INTO public.member(group_id, name, email) VALUES (0, 'Helene','b@b.b');
INSERT INTO public.member(group_id, name, email) VALUES (1, 'Yannick','c@c.c');

INSERT INTO public.wall_message(title, content,created_at,updated_at, author_id) VALUES ('Lorem Ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet leo nec neque mattis imperdiet. Mauris mattis accumsan sem congue efficitur. Vivamus lacinia ipsum nunc, pellentesque dapibus ipsum blandit nec. Fusce placerat metus at porttitor consectetur. Vestibulum urna sem, ultrices non metus sed, semper consequat ex. Praesent libero mi, ultrices non euismod ultrices, blandit vel tellus. Aenean nec velit laoreet, efficitur orci nec, lacinia purus. Aliquam sollicitudin consequat enim. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce vel nulla nibh. Ut scelerisque nibh ac ipsum sollicitudin pharetra. Duis ornare, massa et sagittis molestie, sapien sem euismod nisl, at posuere tellus leo a orci. ','2019-02-23', NOW(),0);
INSERT INTO public.wall_message(title, content,created_at,updated_at, author_id) VALUES ('Court titre', 'Ceci est une phrase.','2019-02-23',NOW(),1);
INSERT INTO public.wall_message(title, content,created_at,updated_at, author_id) VALUES ('Happy Birthday', 'HAPPY BIRTHDAY','2019-05-23',NOW(),1);
INSERT INTO public.wall_message(title, content,created_at,updated_at, author_id) VALUES ('Hello World', 'Hello World','2019-02-23',NOW(),2);

INSERT INTO public.comments(wall_message_id, title, content,created_at,updated_at, author_id) VALUES(1,'Génial!','Bon travail. Je vais en parler à Galien.',NOW(),NOW(),1);
INSERT INTO public.comments(wall_message_id, title, content,created_at,updated_at, author_id) VALUES(1,'Commentaire Deux','Texte du commentaire Deux',NOW(),NOW(),0);
INSERT INTO public.comments(wall_message_id, title, content,created_at,updated_at, author_id) VALUES(2,'Commentaire Trois','III',NOW(),NOW(),0);