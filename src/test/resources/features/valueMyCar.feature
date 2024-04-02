 Feature: Value My Car
  As a User I want to compare my car details
  against the data obtained from Carzoo value my car website


 Scenario: Check my value
  Given Kevin is on the carzoo value my car homepage
  When Kevin performs a search of car registrations from his list "src/test/resources/carData/cz_car_input_v3.txt" to know how much the cars are worth
  Then Kevin can compare what is present in his "src/test/resources/carData/cz_car_output_v3.txt" against the data obtained from Carzoo website