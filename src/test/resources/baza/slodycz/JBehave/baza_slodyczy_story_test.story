Scenario:  Find candy by id
Given an id equals 2
When the item with id 2 is added
Then check is in list with id equals 2
Scenario:  Find candy by Name
Given an Name equals Czekolada
When the item with name Czekolada is added
Then check is in list with name Czekolada
Scenario:  Find candy by Description
Given an Description equals Slodka
When the item with description Slodka is added
Then check is in list with description Slodka
Scenario:  Add items to list and delete it
Given Create database:
|id|name|description|
|1|Czekolada|Slodka|
|2|Baton|Pawelek|
|3|Lizak|CzupaCzups|
When 3 items in database
And Items are deleted
Then table is empty
