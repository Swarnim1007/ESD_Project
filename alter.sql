{\rtf1\ansi\ansicpg1252\cocoartf2758
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- Adding foreign key constraint to Hostel table\
ALTER TABLE Hostel\
ADD CONSTRAINT fk_hostel_student\
FOREIGN KEY (student_id) REFERENCES Student(id);\
\
-- Adding foreign key constraints to SwapApplication table\
ALTER TABLE SwapApplication\
ADD CONSTRAINT fk_swap_applicant\
FOREIGN KEY (applicant_id) REFERENCES Student(id);\
\
ALTER TABLE SwapApplication\
ADD CONSTRAINT fk_swap_recipient\
FOREIGN KEY (recipient_id) REFERENCES Student(id);\
}