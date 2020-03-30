'use strict'; // always coding in strict mode is good behvior.
import React from 'react'; // equal to var React = require('react');
import ReactDOM from 'react-dom';
import Logo from './components/Logo';

ReactDOM.render(
		<h1>
			<Logo />Welcome to The App!
		</h1>,
		document.getElementById('app')
);