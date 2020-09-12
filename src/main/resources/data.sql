DELETE
FROM SURVEYS;

DELETE
FROM TOPICS;

DELETE
FROM USERS;

INSERT INTO USERS (USERID, NAME)
    VALUES  (1, 'IAN'),
            (2, 'EMMA'),
            (3, 'EVAN');

INSERT INTO TOPICS (TOPICID, NAME, USERID)
    VALUES  (4, 'LABS STANDUP', 1),
            (5, 'JW FANTASY', 1),
            (6, 'LAWN CARE TEAM', 3);

INSERT INTO SURVEYS (SURVEYID, DATE, TOPICID)
    VALUES  (7, '2020:02:3 - 15:33', 5),
            (8, '2020:03:3 - 15:33', 5),
            (9, '2020:05:3 - 15:33', 6);

alter sequence hibernate_sequence restart with 40;

