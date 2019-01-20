//Convert JSON String to PHP Array or Object

<?php
  // JSON string
  $someJSON = '[{"name":"Jonathan Suh","gender":"male"},{"name":"William Philbin","gender":"male"},{"name":"Allison McKinnery","gender":"female"}]';

  // Convert JSON string to Array
  $someArray = json_decode($someJSON, true);
  print_r($someArray);        // Dump all data of the Array
  echo $someArray[0]["name"]; // Access Array data

  // Convert JSON string to Object
  $someObject = json_decode($someJSON);
  print_r($someObject);      // Dump all data of the Object
  echo $someObject[0]->name; // Access Object data
?>

//Loop through PHP Array or Object
//Loop through a PHP array or object with a foreach loop.

<?php
  // Loop through Array
  $someArray = ...; // Replace ... with your PHP Array
  foreach ($someArray as $key => $value) {
    echo $value["name"] . ", " . $value["gender"] . "<br>";
  }

  // Loop through Object
  $someObject = ...; // Replace ... with your PHP Object
  foreach($someObject as $key => $value) {
    echo $value->name . ", " . $value->gender . "<br>";
  }
?>
//Note the differences in accessing the values of an array vs an object.

//Convert PHP Array or Object to JSON String
//PHP also features a json_encode function to convert an array or object into a string. Read more about the json_encode function from PHP’s documentation.

<?php
  // Array
  $someArray = [
    [
      "name"   => "Jonathan Suh",
      "gender" => "male"
    ],
    [
      "name"   => "William Philbin",
      "gender" => "male"
    ],
    [
      "name"   => "Allison McKinnery",
      "gender" => "female"
    ]
  ];

  // Convert Array to JSON String
  $someJSON = json_encode($someArray);
  echo $someJSON;
?>
//Note that I’m using the short array syntax that’s featured in PHP 5.4+.

<?php
  $array = array(
    "foo" => "bar",
    "bar" => "foo"
  );

  // as of PHP 5.4
  $array = [
    "foo" => "bar",
    "bar" => "foo"
  ];
?>

//Convert JSON String to JavaScript Object
//JavaScript has a built-in JSON.parse() method that parses a JSON string and returns an object.

<script>
  // Convert JSON String to JavaScript Object
  var JSONString = '[{"name":"Jonathan Suh","gender":"male"},{"name":"William Philbin","gender":"male"},{"name":"Allison McKinnery","gender":"female"}]';

  var JSONObject = JSON.parse(JSONString);
  console.log(JSONObject);      // Dump all data of the Object in the console
  alert(JSONObject[0]["name"]); // Access Object data
</script>
JSON.parse() is very well-supported, but there are browsers that do not support it (i.e. <= IE 7. More information at caniuse.com).

jQuery 1.x has a $.parseJSON() method that should fill in the gaps for those browsers if you’re needing to support them. You can also use the JSON-js library as a polyfill.

<script>
  // Convert JSON String to JavaScript Object with jQuery
  var JSONString = "..."; // Replace ... with your JSON String

  var JSONObject = $.parseJSON(JSONString);
  console.log(JSONObject);      // Dump all data of the Object in the console
  alert(JSONObject[0]["name"]); // Access Object data
</script>
Loop through JavaScript Object
You can then loop through a JavaScript object using a for in loop.

<script>
  // Loop through Object
  var JSONObject = ...; // Replace ... with your JavaScript Object

  for (var key in JSONObject) {
    if (JSONObject.hasOwnProperty(key)) {
      console.log(JSONObject[key]["name"] + ", " + JSONObject[key]["gender"]);
    }
  }
</script>
Convert JavaScript Object to JSON String
JavaScript has a JSON.stringify method to convert a value into a JSON string.

<script>
  var JSONObject = [
    {
      "name": "Jonathan Suh",
      "gender": "male"
    },
    {
      "name": "William Philbin",
      "gender": "male"
    },
    {
      "name": "Allison McKinnery",
      "gender": "female"
    }
  ];

  var JSONString = JSON.stringify(JSONObject);
  alert(JSONString);
</script>
//Like JSON.parse, JSON.stringify is not supported in dinosaur browsers like <= IE 7. You can use the JSON-js library to polyfill JSON.stringify as well.
