insert into worker(/*id,*/ for_name, fam_name, shortcut, section, harness, reserve, absence, note, vp)
 	values (/*0,*/ 'Petr', 'Pribyl', 'SPI', 'AB', 8, 0, 0, '', 'A');

insert into worker(/*id,*/ for_name, fam_name, shortcut, section, harness, reserve, absence, note, vp)
 	values (/*1,*/ 'Martin', 'Bikl', 'BIK', 'AB', 8, 0, 0, '', 'N');

insert into worker(/*id,*/ for_name, fam_name, shortcut, section, harness, reserve, absence, note, vp)
 	values (/*2,*/ 'Jan', 'Novak', 'NON', 'AB', 8, 0, 0, '', 'A');

  
insert into plan(/*id,*/ start_date, end_date, days, log)
	values (/*0,*/ to_date('1.12.2020','dd.mm.yyyy'), to_date('31.12.2020','dd.mm.yyyy'), 20 , '');
  
	
insert into alocation(/*id,*/ id_worker, id_plan, idVP, man_days)
	values (/*0,*/ 0, 0, 2, 5);
  
insert into alocation(/*id, */id_worker, id_plan, idVP, man_days)
	values (/*1,*/ 1, 0, 2, 3);
  
insert into alocation(/*id, */id_worker, id_plan, idVP, man_days)
	values (/*2,*/ 1, 0, 2, 8);
  
insert into alocation(/*id, */id_worker, id_plan, idVP, man_days)
	values (/*3,*/ 1, 0, 0, 9);

commit;