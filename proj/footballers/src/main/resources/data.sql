insert into position_list (id, position) values (1, 'FORWARD'), (2, 'MIDFIELDER'), (3, 'DEFENDER'), (4, 'GOALKEEPER');
COMMIT;
alter table players modify column img longblob;
COMMIT;
alter table teams modify column img longblob;
COMMIT;