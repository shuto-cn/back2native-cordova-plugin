var exec = require('cordova/exec');

exports.back = function (success, error) {
	exec(success, error, 'back2native', 'back', []);
};

// exports.home = function (success, error) {
// 	exec(success, error, 'back2native', 'home', []);
// };

// exports.dismiss = function (success, error) {
// 	exec(success, error, 'back2native', 'dismiss', []);
// };

// exports.pop = function (success, error) {
// 	exec(success, error, 'back2native', 'pop', []);
// };