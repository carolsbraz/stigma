 var firebaseConfig = {
     apiKey: "AIzaSyC7v_L6VukQjLHz9oqoN_VB5A6JxXEzha8",
     authDomain: "stigmaapp-c9e35.firebaseapp.com",
     databaseURL: "https://stigmaapp-c9e35.firebaseio.com",
     projectId: "stigmaapp-c9e35",
     storageBucket: "stigmaapp-c9e35.appspot.com",
     messagingSenderId: "559523489462",
     appId: "1:559523489462:web:ebad7b5d33174346ea6817"
 };

 // Initialize Firebase
 firebase.initializeApp(firebaseConfig);

 var db = firebase.database().ref();
