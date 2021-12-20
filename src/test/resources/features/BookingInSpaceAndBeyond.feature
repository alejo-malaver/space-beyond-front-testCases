# New feature
# Tags: @Booking
# language: en
# Author : alejoil777@gmail.com

Feature: Make web reservation for trip to space
  As a buyer in Space and Beyond
  I want to be able to make booking
  To travel to different destinations in space without having to go to a physical place, saving time

  @Booking
  Scenario: Carry out the complete reservation process with random data
    Given there is a user browsing the 'main' web page in Space and Beyond
    When select a destination at random, without any filter
    And fill out the CHECKOUT form data
    Then the PAY NOW button is never enabled