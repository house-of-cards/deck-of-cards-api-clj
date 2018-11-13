$employeesJson = '{"employees":[
    { "firstName":"John", "lastName":"Doe" },
    { "firstName":"Anna", "lastName":"Smith" },
    { "firstName":"Peter", "lastName":"Jones" }
]}'

$employeesObject = ConvertFrom-Json –InputObject $employeesJson


$employeesObject.employees


