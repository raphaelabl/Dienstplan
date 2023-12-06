# Dienstplan
bh dienstplan ersteller



Request an:

localhost:8080/plan


json:

{
  "planDetails": [
    {
      "id": null,
      "date": "2023-12-01",
      "type": "Norm",
      "onDutyDay": [],
      "onDutyNight": [],
      "onDutyLesson": [],
      "toFewFighters": false
    },
    {
      "id": null,
      "date": "2023-12-02",
      "type": "Ausbildung",
      "onDutyDay": [],
      "onDutyNight": [],
      "onDutyLesson": [],
      "toFewFighters": false
    }
  ],
  "fighterDetails": [
    {
      "id": null,
      "fId": 1
      "name": "Name",
      "freeDays": [
        "2023-12-10",
        "2023-12-16",
        "2023-12-17",
        "2023-12-23"
      ],
      "cntDays": 0,
      "cntNights": 0
    },
    {
      "id": null,
      "fId": 2,
      "name": "Name2",
      "freeDays": [
        "2023-12-09",
        "2023-12-13",
        "2023-12-16",
        "2023-12-18"
      ],
      "cntDays": 0,
      "cntNights": 0
    }
  ]
}


fId muss Händisch gesetzt werden
