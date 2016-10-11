insert into STATUS_CODE (status, descr) values (1, 'UNCONFIRMED');
insert into STATUS_CODE (status, descr) values (2, 'IN_REVIEW');
insert into STATUS_CODE (status, descr) values (3, 'DUPLICATE');
insert into STATUS_CODE (status, descr) values (4, 'REJECTED');
insert into STATUS_CODE (status, descr) values (5, 'CONFIRMED');

insert into ROLE (role_id, name, descr) values (1, 'ADMIN', 'Gadget Catalog Administrator');
insert into ROLE (role_id, name, descr) values (2, 'USER', 'Gadget Catalog User');
insert into ROLE (role_id, name, descr) values (3, 'AUTHOR', 'Author');
insert into ROLE (role_id, name, descr) values (4, 'EDITOR', 'Editor');


insert into USER (user_id, login, password, name, email) values (1, 'jim', 'jim','Jim F.','jim@jimfarley.org');
insert into USER (user_id, login, password, name, email) values (2, 'joe', 'joe', 'Joe Sixpack', 'joe@yahoo.com');
insert into USER (user_id, login, password, name, email) values (3, 'mike', 'mike', 'Mike the Editor', 'mike@wepublish.com');
insert into USER (user_id, login, password, name, email) values (4, 'jane', 'jane', 'Jane the Admin', 'jane@gadgetcatalog.com');

insert into USER_ROLE_ASSN (user_id, role_id) values (1,3);
insert into USER_ROLE_ASSN (user_id, role_id) values (2,2);
insert into USER_ROLE_ASSN (user_id, role_id) values (3,4);
insert into USER_ROLE_ASSN (user_id, role_id) values (4,1);


