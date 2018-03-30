INSERT IGNORE INTO users (id, login, password, ukr_name, ukr_surname, ukr_father_name, eng_name, eng_surname, eng_father_name, role)
VALUES
  (1, 'admin', 'admin', 'Валерій', 'Діденко', 'Олександрович', 'Valery', 'Didenko', 'Alexandrovich', 'ADMIN'),
  (2, 'user', 'user', 'Микола', 'Іванов', 'Васильович', 'Nikolay', 'Ivanov', 'Vasilyovich', 'USER');

INSERT IGNORE INTO students (id, usede_id, ukr_surname, ukr_name, ukr_father_name, ukr_country, eng_surname, eng_name, eng_father_name, eng_country, degree, date_of_birth, get_into_year, graduate_year, deducted)
VALUES
  (1, 7654321, 'Целковський', 'Олександр', 'Анатолійович', 'Україна', 'Tselkovsky', 'Oleksander', 'Anatoliyovich',
      'Ukraine', 'BACHELOR', '1996-04-18', 2014, 2017, FALSE),
  (2, 6132863, 'Куриленко', 'Аліна', 'Олегівна', 'Україна', 'Kurilenko', 'Alina', 'Olegivna', 'Ukraine', 'BACHELOR',
   '1999-02-25', 2016, 2017, FALSE),
  (3, 1234567, 'Ворошкевич', 'Ніка', 'Кирилівна', 'Україна', 'Voroshkevych', 'Nika', 'Kirilivna', 'Ukraine', 'BACHELOR',
   '1996-07-27', 2014, 2017, TRUE);

INSERT IGNORE INTO specialties (id, ukr_name, eng_name, ukr_specialization, eng_specialization, year) VALUES
  (1, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Спеціалізовані комп\'ютерні системи',
   'Specialized computer systems', 2015),
  (2, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Спеціалізовані комп\'ютерні системи',
   'Specialized computer systems', 2016),
  (3, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Спеціалізовані комп\'ютерні системи',
   'Specialized computer systems', 2017),
  (4, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Комп\'ютерні системи та мережі',
   'Computer systems and networks', 2015),
  (5, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Комп\'ютерні системи та мережі',
   'Computer systems and networks', 2016),
  (6, '123 - Комп\'ютерна інженерія', '123 - Computer engineering', 'Комп\'ютерні системи та мережі',
   'Computer systems and networks', 2017);

INSERT IGNORE INTO subjects (id, semester, ukr_name, eng_name, code, credit, specialty_id) VALUES
  (1, 1, 'WEB-програмування', 'WEB-programming', 'ПП В.01', 4.5, 3),
  (2, 1, 'Алгоритми та методи обчислень', 'Algorithms and methods of computation', 'ПП O.01', 4.0, 3),
  (3, 1, 'Вища математика', 'Advanced Mathematics', 'ЗП О.04', 6.0, 3),
  (4, 1, 'Іноземна мова', 'Foreign Language', 'ЗП В.01', 1.5, 3),
  (5, 1, 'Історія України', 'History of Ukraine', 'ЗП О.02', 3.0, 3),
  (6, 1, 'Правознавство', 'Law Codes', 'ЗПП В.02.01', 1.5, 3),
  (7, 1, 'Програмування', 'Programming', 'ПП О.02', 4.0, 3),
  (8, 1, 'Фізика', 'Physics', 'ЗП О.05', 4.0, 3),
  (9, 1, 'Фізичне виховання', 'Physical Education', 'ЗП В.9', 2.0, 3),
  (10, 2, '3D-Моделювання', '3D-Modelling', 'ПП В.02', 5.5, 3),
  (11, 2, 'Вища математика', 'Advanced Mathematics', 'ЗП О.04', 6.0, 3),
  (12, 2, 'Дискретні обчислення', 'Discrete Calculations', 'ЗП В.02.3', 4.0, 3),
  (13, 2, 'Іноземна мова', 'Foreign Language', 'ЗП В.01', 1.5, 3),
  (14, 2, 'Комп\'ютерна логіка', 'Computer Logic', 'ПП О.03', 4.5, 3),
  (15, 2, 'Політологія', 'Political Science', 'ЗПП В.02.02', 1.5, 3),
  (16, 2, 'Програмування', 'Programming', 'ПП О.02', 4.0, 3),
  (17, 2, 'Програмування (курсова робота)', 'Programming (project work)', 'ПП О.02', 1.0, 3),
  (18, 2, 'Фізика', 'Physics', 'ЗП О.05', 3.5, 3),
  (19, 2, 'Фізичне виховання', 'Physical Education', 'ЗП В.9', 2.0, 3);

INSERT IGNORE INTO exclusions (id, ukr_reason, eng_reason) VALUES
  (1,
   'У зв\'язку з переведенням до Національного технічного університету України \"Київський політехнічний інститут імені Ігоря Сікорського\"',
   'Reazon: transfer for study to National technical university of Ukraine \"Sikorsky Kyiv Polytechnic Institute\"');

INSERT IGNORE INTO grades (id, student_id, subject_id, onpu_grade, euro_grade) VALUES
  (1, 2, 1, 100, 'A'),
  (2, 2, 2, 100, 'A'),
  (3, 2, 3, 85, 'B'),
  (4, 2, 4, 80, 'B'),
  (5, 2, 5, 90, 'A'),
  (6, 2, 6, 90, 'A'),
  (7, 2, 7, 100, 'A'),
  (8, 2, 8, 67, 'C'),
  (9, 2, 9, 90, 'A'),
  (10, 2, 10, 100, 'A'),
  (11, 2, 11, 90, 'A'),
  (12, 2, 12, 95, 'A'),
  (13, 2, 13, 96, 'A'),
  (14, 2, 14, 85, 'B'),
  (15, 2, 15, 100, 'A'),
  (16, 2, 16, 100, 'A'),
  (17, 2, 17, 100, 'A'),
  (18, 2, 18, 75, 'B'),
  (19, 2, 19, 100, 'A');

INSERT IGNORE INTO positions (id, position_type, position_name) VALUES
  (1, 'ICS', 'DIRECTOR'),
  (2, 'ICS', 'DIRECTOR_INTERIM'),
  (3, 'ICS', 'VICE_DIRECTOR'),
  (4, 'ICS', 'DEAN'),
  (5, 'ICS', 'VICE_DEAN'),
  (6, 'ONPU', 'RECTOR'),
  (7, 'ONPU', 'RECTOR_INTERIM'),
  (8, 'ONPU', 'VICE_RECTOR');

INSERT IGNORE INTO signs (id, ukr_surname, ukr_name, ukr_father_name, eng_surname, eng_name, eng_father_name, position_id)
VALUES
  (1, 'Антощук', 'Світлана', 'Григорівна', 'Antoshchuk', 'Svitlana', 'Grigorivna', 4),
  (2, 'Нестеренко', 'Сергій', 'Андрійович', 'Nesterenko', 'Sergy', 'Andriyovich', 7),
  (3, 'Оборський', 'Валентин', 'Михайлович', 'Oborsky', 'Valentin', 'Mikhaylovich', 6);

INSERT IGNORE INTO `references` (id, number, sign_date, `order`, order_date, specialty_id, exclusion_id, user_id)
VALUES
  (1, 602017, '2017-11-25', '№965-c', '2017-10-23', 3, 1, 2);

INSERT IGNORE INTO signs_references (sign_id, reference_id) VALUES
  (1, 1), (2, 1);