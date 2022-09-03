{
  "job": {
    "setting": {
      "speed": {
        "channel": 1
      }
    },
    "content": [
      {
        "reader": {
          "name": "${reader_type}",
          "parameter": {
            "username": "root",
            "password": "LZM123456",
            "column": [
              "${cols}"
            ],
            "splitPk": "${split_pk}",
            "connection": [
              {
                "table": [
                  "${src_object_name}"
                ],
                "jdbcUrl": [
                  "jdbc:mysql://132.232.100.207:3310/al_test1"
                ]
              }
            ],
            "where": "${where}"
          }
        },
        "writer": {
          "name": "${writer_type}",
          "parameter": {
            "writeMode": "insert",
            "username": "root",
            "password": "LZM123456",
            "column": [
              "${cols}"
            ],
            "session": [
              "set session sql_mode='ANSI'"
            ],
            "preSql": [
              "delete from ${des_object_name} where ${where}"
            ],
            "connection": [
              {
                "jdbcUrl": "jdbc:mysql://132.232.100.207:3310/al_test2?useUnicode=true&characterEncoding=utf8",
                "table": [
                  "${des_object_name}"
                ]
              }
            ]
          }
        }
      }
    ]
  }
}