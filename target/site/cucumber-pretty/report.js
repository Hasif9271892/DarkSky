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
  "duration": 5022117005,
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
  "location": "DarkSkySD.goToRegisterPage()"
});
formatter.result({
  "duration": 1225052617,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.registerButton()"
});
formatter.result({
  "duration": 52171666,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyErrorMessage()"
});
formatter.result({
  "duration": 60900064,
  "status": "passed"
});
formatter.after({
  "duration": 151819753,
  "status": "passed"
});
formatter.before({
  "duration": 2433912852,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify current Temperature should not be greater or less than the Temperature from Daily Timeline",
  "description": "",
  "id": "darksky-feature;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@darksky-2"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I am on DarkSky home page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I verify current temperature is not greater or less then temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iAmOnHomePage()"
});
formatter.result({
  "duration": 18142010,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verifyCurrentTempsToHighLow()"
});
formatter.result({
  "duration": 540902144,
  "status": "passed"
});
formatter.after({
  "duration": 125754542,
  "status": "passed"
});
formatter.before({
  "duration": 2093116098,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "darksky-feature;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@darksky-3"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "I am on DarkSky home page",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I expand today\u0027s timeline",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkySD.iAmOnHomePage()"
});
formatter.result({
  "duration": 8385915,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.expandTimeline()"
});
formatter.result({
  "duration": 4068418530,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkySD.verify()"
});
