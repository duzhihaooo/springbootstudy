# springbootstudy

- user

  | 字段      | 字段名称 | 字段英文名 |
  | --------- | -------- | ---------- |
  | id        | 主键     | id         |
  | user_name | 用户名   | user_name  |

  

- role

  | 字段      | 字段名称 | 字段英文名 |
  | --------- | -------- | ---------- |
  | id        | 主键     | id         |
  | role_name | 角色名称 | role_name  |

- N个用户对应一个角色:user_role

  | 字段    | 字段名称 | 字段英文名 |
  | ------- | -------- | ---------- |
  | id      | 主键     | id         |
  | role_id | 角色id   | role_id    |
  | user_id | 用户id   | user_id    |

  
