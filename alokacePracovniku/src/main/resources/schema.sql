CREATE TABLE worker (
   id INT IDENTITY PRIMARY KEY,
   for_name VARCHAR (255),
   fam_name VARCHAR (255),
   shortcut VARCHAR (3),
   section VARCHAR (255),      
   harness INT,      
   reserve INT,      
   absence INT,      
   note VARCHAR (2000),
   vp VARCHAR (1) NOT NULL
); 

CREATE TABLE alocation (
   id INT IDENTITY PRIMARY KEY,
   id_worker INT NOT NULL,
   id_plan INT NOT NULL,
   idVP INT NOT NULL,
   man_days INT
);

CREATE TABLE plan (
   id INT IDENTITY PRIMARY KEY,
   start_date DATE NOT NULL,
   end_date DATE NOT NULL,
   days INT,
   log VARCHAR(2000)
);
