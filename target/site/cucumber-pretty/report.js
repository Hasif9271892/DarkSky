$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("darksky.feature");
formatter.feature({
  "line": 2,
  "name": "Darksky Feature",
  "description": "",
  "id": "darksky-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@darksky"
    }
  ]
});
formatter.before({
  "duration": 3959266089,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Verify on register error",
  "description": "",
  "id": "darksky-feature;verify-on-register-error",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@darksky-1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am on register page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click on register button",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I verify error message",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkskySD.goToRegisterPage()"
});
formatter.result({
  "duration": 1123902976,
  "status": "passed"
});
formatter.match({
  "location": "DarkskySD.registerButton()"
});
formatter.result({
  "duration": 74804610,
  "status": "passed"
});
formatter.match({
  "location": "DarkskySD.verifyErrorMessage()"
});
formatter.result({
  "duration": 81494606,
  "status": "passed"
});
formatter.after({
  "duration": 160246553,
  "status": "passed"
});
});