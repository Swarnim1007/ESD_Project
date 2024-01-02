{\rtf1\ansi\ansicpg1252\cocoartf2758
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh18000\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- Insert students\
INSERT INTO student (id, age, first_name, last_name, email, password, other_details, gpa, year, enrollment_year)\
VALUES\
  (1, 29, 'Swarnim', 'Kukreti', 'swarnim@gmail.com', '1234', '', 3.4, 4, 2025),\
  (2, 30, 'Priya', 'Negi', 'priya@gmail.com', '1234', '', 3.4, 4, 2025);\
\
-- Insert hostels\
INSERT INTO hostel (id, name, capacity, room_number, student_id)\
VALUES\
  (1, 'Bhaskara', 4, 230, 1),\
  (2, 'Bhaskara', 2, 233, 2);\
\
-- Insert swap applications\
INSERT INTO swap_application (id, student_from_id, student_to_id, reason, status, response)\
VALUES\
  (1, 1, 2, 'Heyy', 'PENDING', 'Bye');\
}