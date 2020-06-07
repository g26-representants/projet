SET search_path TO projet;


-- Supprimer toutes les données
DELETE FROM service;
DELETE FROM concerner;
DELETE FROM memo;
DELETE FROM telephone;
DELETE FROM personne;
DELETE FROM categorie;
DELETE FROM role;
DELETE FROM compte;


-- Compte

INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
  (1, 'geek', 'geek', 'geek@3il.fr' ),
  (2, 'chef', 'chef', 'chef@3il.fr' ),
  (3, 'job', 'job', 'job@3il.fr' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;


-- Role

INSERT INTO role (idcompte, role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' ),
  ( 3, 'UTILISATEUR' );


-- Categorie
  
INSERT INTO categorie (idcategorie, libelle ) VALUES 
  (1, 'Employés' ),
  (2, 'Partenaires' ),
  (3, 'Clients' ),
  (4, 'Fournisseurs' ),
  (5, 'Dirigeants' );

ALTER TABLE categorie ALTER COLUMN idcategorie RESTART WITH 6;


-- Personne

INSERT INTO personne (idpersonne, idcategorie, nom, prenom) VALUES 
  ( 1, 1, 'GRASSET', 'Jérôme' ),
  ( 2, 1, 'BOUBY', 'Claude' ),
  ( 3, 1, 'AMBLARD', 'Emmanuel' );

ALTER TABLE personne ALTER COLUMN idpersonne RESTART WITH 4;


-- Telephone

INSERT INTO telephone (idtelephone, idpersonne, libelle, numero ) VALUES 
  ( 11, 1, 'Portable', '06 11 11 11 11' ),
  ( 12, 1, 'Fax', '05 55 99 11 11' ),
  ( 13, 1, 'Bureau', '05 55 11 11 11' ),
  ( 21, 2, 'Portable', '06 22 22 22 22' ),
  ( 22, 2, 'Fax', '05 55 99 22 22' ),
  ( 23, 2, 'Bureau', '05 55 22 22 22' ),
  ( 31, 3, 'Portable', '06 33 33 33 33' ),
  ( 32, 3, 'Fax', '05 55 99 33 33' ),
  ( 33, 3, 'Bureau', '05 55 33 33 33' );

ALTER TABLE telephone ALTER COLUMN idtelephone RESTART WITH 100;


-- Memo

INSERT INTO memo (idmemo, titre, description, flagurgent, statut, effectif, budget, echeance, idcategorie ) VALUES 
  ( 1, 'Mémo n°1', 'Texte du mémo n°1', TRUE,  2,   2,   1234.56,   {d  '2020-02-25' }, 1 ),
  ( 2, 'Mémo n°2', 'Texte du mémo n°2', FALSE, 1,   4,   5000.00,   {d  '2020-05-18' }, 2 ),
  ( 3, 'Mémo n°3', NULL, TRUE, 0, NULL, NULL, NULL, NULL );

ALTER TABLE memo ALTER COLUMN idmemo RESTART WITH 4;


-- Concerner

INSERT INTO concerner (idmemo, idPersonne) VALUES 
  ( 1, 1 ),
  ( 1, 2 ),
  ( 1, 3 ),
  ( 2, 1 ),
  ( 2, 2 );


-- Service

INSERT INTO service ( idservice, nom, anneecreation, flagsiege ) VALUES 
  ( 1, 'Direction', 2007, TRUE ),
  ( 2, 'Comptabilité', NULL, TRUE ),
  ( 3, 'Agence Limoges', 2008, FALSE ),
  ( 4, 'Agence Brive', 2014, FALSE );


ALTER TABLE service ALTER COLUMN idservice RESTART WITH 5;

INSERT INTO boldair (idboldair, anneeBoldair, ravitaillement, parking, dossards, buvette, repas, signaleur) VALUES
	(1, 2017, 8, 8, 8, 9, 4, 5),
	(2, 2018, 8, 8, 8, 9, 4, 5),
	(3, 2019, 8, 8, 8, 9, 4, 5);
	
ALTER TABLE boldair ALTER COLUMN idboldair RESTART WITH 8;



------------------------------------------------------------
--  Equipe
------------------------------------------------------------
INSERT INTO equipe (idequipe, nom_equipe, nb_repas, valide, paye) VALUES
  (1,'zanzan',2,FALSE,FALSE),
  (2,'chefai',1,FALSE,FALSE);
  --(3,'jobini',2,FALSE,FALSE);
  

ALTER TABLE equipe ALTER COLUMN idequipe RESTART WITH 4;


------------------------------------------------------------
--  Participants
------------------------------------------------------------
INSERT INTO participant (idparticipant,idequipe, nom_participant,prenom_participant,date_naissance_participant,tel_participant,email_participant,addresse_participant,code_postal_participants,certificat_medicale_participant,carte_id_participant,sexe_participant) VALUES
  (1,1, 'anwar','rawnar','29/06/1997','0767432752','anwar@gmail.fr','52 Rue du Lapin',87000,'PDF','UN AUTRE PDF',FALSE),
  (2,2, 'layla','saad','01/12/1997','0567432752','layla@gmail.fr','13 Rue du la revolution',91000,'PDF','UN AUTRE PDF',TRUE),
  (3,1, 'khawla','soraya','20/10/1997','0678932752','khawlya@gmail.fr','Rue du coc',98000,'PDF','UN AUTRE PDF',FALSE),
  (4,2, 'ramen','sora','20/11/1997','0687532752','khhihlya@gmail.fr','Rue du croco',98700,'PDF','UN AUTRE PDF',FALSE);

ALTER TABLE participant ALTER COLUMN idparticipant RESTART WITH 6;


------------------------------------------------------------
--  Benevole_Participant
------------------------------------------------------------
INSERT INTO benevole_participant (idbenevole_participant,nom_benevole_participant,prenom_benevole_participant,email_benevole_participant,addresse_benevole_participant,tel_benevole_participant,code_postal_benevole_participants,date_naissance_benevole_participant) VALUES
  (1, 'salma','olai','salma@gmail.fr','02 Rue du evry', '06 11 11 11 11',87100,'31/05/1996'),
  (2, 'hajar','ali','hajar@gmail.fr','13 Rue du la bellevie','05 55 33 33 33',91000,'02/12/1995'),
  (3, 'salwa','panta','salwa@gmail.fr','Rue du coli','06 33 33 33 33',98000,'20/11/1998');

ALTER TABLE benevole_participant ALTER COLUMN idbenevole_participant RESTART WITH 4;

------------------------------------------------------------
--  Poste_Benevole
------------------------------------------------------------
INSERT INTO poste_benevole (idposte,nom_poste,heure_debut,heure_fin) VALUES
  (1, 'Parking voiture','08:30:00.00','16:45:00.00'),
  (2, 'Signaleurs','08:00:00.00','16:00:00.00'),
  (3, 'Buvette','08:45:00.00','16:00:00.00');
 
ALTER TABLE poste_benevole ALTER COLUMN idposte RESTART WITH 4;

------------------------------------------------------------
--  Resonsable_Benevole
------------------------------------------------------------
INSERT INTO responsable_benevole(idresponsable,nom_responsable,prenom_responsable,date_de_naissance_res_benevole,tel_responsable_benevole,adresse_email_res_benevole,adresse_res_benevole,code_postal_responsable_benevole) VALUES
  (1, 'antony','salomey','01/01/1978', '06 22 22 11 11','antony@gmail.fr','03 Rue de la derb',87000),
  (2, 'hajar','ali','22/01/1989', '05 55 25 33 33','hajar@gmail.fr','13 Rue du la bellevie',93000),
  (3, 'salwa','panta','22/12/1987','06 33 33 01 65','salwa@gmail.fr','Rue du coli',98100);
 
ALTER TABLE responsable_benevole ALTER COLUMN idresponsable RESTART WITH 100;


------------------------------------------------------------
--  Resonsable_Benevole
------------------------------------------------------------
INSERT INTO epreuve(idepreuve,tarif_epreuve,type_epreuve,date_epreuve,nom_epreuve) VALUES
  (1, 14,'Sportif','01/10/2020', 'foot'),
  (2, 20,'Sportif','22/09/2020', 'course'),
  (3, 22,'Dance','22/11/2020','ballet');
 
ALTER TABLE epreuve ALTER COLUMN idepreuve RESTART WITH 4;

------------------------------------------------------------
--  Responsable_Administratif
------------------------------------------------------------
INSERT INTO responsable_administratif(idresadmin,nom_responsable_admin,prenom_responsable_admin,date_naissance_res_admin,tel_responsable_admin,adresse_email_res_admin,adresse_respnsable_admin,code_postal_responsable_admin) VALUES
  (1, 'liyam','ghita','11/01/1962', '06 01 01 01 11','liyam@gmail.fr','03 Rue du L',88000),
  (2, 'basma','mery','14/06/1978', '05 55 25 21 33','basma@gmail.fr','13 Rue shinigami',94000),
  (3, 'kira','haai','25/02/1987','06 33 65 01 65','kira@gmail.fr','Rue du konitchiwa',98000);
 
 
ALTER TABLE responsable_administratif ALTER COLUMN idresadmin RESTART WITH 4;


------------------------------------------------------------
--  Appartenir
------------------------------------------------------------
INSERT INTO appartenir (idequipe, idparticipant) VALUES 
  ( 1, 1 ),
  ( 1, 2 ),
  ( 2, 3 ),
  ( 2, 4 );
  




--INSERT INTO numero_telephone(idtelephone,idparticipant,libelle,numero) VALUES
 --(1, 2,'FRANCE', '06 01 01 01 11'),
  --(2, 3,'MAROC', '05 55 25 21 33'),
 -- (3, 1,'USA','06 33 65 01 65');

--ALTER TABLE numero_telephone ALTER COLUMN idtelephone RESTART WITH 4;


