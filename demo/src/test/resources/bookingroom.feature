Feature: Booking Room

  Scenario: Booking a room
            Given Open the booking application
            When select the room
            And select the date
            And Enter the details
            Then Book the ticket
            And Confirm the booking
