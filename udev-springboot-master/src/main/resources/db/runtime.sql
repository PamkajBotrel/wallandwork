INSERT INTO public.book(id, title, author) VALUES (0, 'LOTR 1', 'JR Tolkien');
INSERT INTO public.book(id, title, author) VALUES (1, 'LOTR 2', 'JR Tolkien');
INSERT INTO public.book(id, title, author) VALUES (2, 'LOTR 3', 'JR Tolkien');

INSERT INTO public.member(id, group_id, name, email) VALUES (0,0, 'Pamkaj','a@a.a');
INSERT INTO public.member(id, group_id, name, email) VALUES (1,0, 'Helene','b@b.b');
INSERT INTO public.member(id, group_id, name, email) VALUES (2,1, 'Yannick','c@c.c');

INSERT INTO public.wall_message(id, title, content,date, author_id) VALUES (0, 'Post1', 'AAAAAA','2019-02-23',0);
INSERT INTO public.wall_message(id, title, content,date, author_id) VALUES (1, 'Post2', 'BBBB','2019-02-23',1);
INSERT INTO public.wall_message(id, title, content,date, author_id) VALUES (2, 'Post3', 'CCCC','2019-02-23',1);
INSERT INTO public.wall_message(id, title, content,date, author_id) VALUES (4, 'Post4', 'DDDD','2019-02-23',2);