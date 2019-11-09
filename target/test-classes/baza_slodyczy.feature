Feature: As a user i need
        to search items
        on the list.




@SearchByName
Scenario: Search by Name
        Given An Name
        When Search by name "Czekolada"
        Then Name should be in list



@SearchById
Scenario: Search by id
        Given An id
        When Search by 2
        Then id should be in list

@SearchByDescription
Scenario: Search by Description
        Given A Description
        When Search by description "Slodka"
        Then Description should be in list

@DeleteListOfItems
Scenario: Delete list of Items
        Given Put items in list
        And Get List of items to delete
                   |1     |
                   |2     |
                   |3     |
        When Delete list of items
        Then Check list is null

