import React from 'react';
/*
 * // this is the old sentence. var Logo = React.createClass({ render:
 * function(){ return <div className="Logo" />; } });
 */

// the new one.
class Logo extends React.Component {
	render() {
		return <div className="Logo" />;
	}
}

export default Logo // equal to module.exports = Logo;
