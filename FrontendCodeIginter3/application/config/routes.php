<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/*
| -------------------------------------------------------------------------
| URI ROUTING
| -------------------------------------------------------------------------
| This file lets you re-map URI requests to specific controller functions.
|
| Typically there is a one-to-one relationship between a URL string
| and its corresponding controller class/method. The segments in a
| URL normally follow this pattern:
|
|	example.com/class/method/id/
|
| In some instances, however, you may want to remap this relationship
| so that a different class/function is called than the one
| corresponding to the URL.
|
| Please see the user guide for complete details:
|
|	https://codeigniter.com/userguide3/general/routing.html
|
| -------------------------------------------------------------------------
| RESERVED ROUTES
| -------------------------------------------------------------------------
|
| There are three reserved routes:
|
|	$route['default_controller'] = 'welcome';
|
| This route indicates which controller class should be loaded if the
| URI contains no data. In the above example, the "welcome" class
| would be loaded.
|
|	$route['404_override'] = 'errors/page_missing';
|
| This route will tell the Router which controller/method to use if those
| provided in the URL cannot be matched to a valid route.
|
|	$route['translate_uri_dashes'] = FALSE;
|
| This is not exactly a route, but allows you to automatically route
| controller and method names that contain dashes. '-' isn't a valid
| class or method name character, so it requires translation.
| When you set this option to TRUE, it will replace ALL dashes in the
| controller and method URI segments.
|
| Examples:	my-controller/index	-> my_controller/index
|		my-controller/my-method	-> my_controller/my_method
*/
$route['default_controller'] = 'main';
$route['404_override'] = '';
$route['translate_uri_dashes'] = FALSE;
$route['main/success'] = 'main/success';

// Main Page
$route[''] = 'main/index';
$route['main/input_data'] = 'main/input_data';

// Adding Data
$route['main/add_project'] = 'main/add_project';
$route['main/add_location'] = 'main/add_location';

// Editing Data
$route['main/edit_project/(:num)'] = 'main/edit_project/$1';
$route['main/edit_location/(:num)'] = 'main/edit_location/$1';

// Updating Data
$route['main/update_project/(:num)'] = 'main/update_project/$1';
$route['main/update_location/(:num)'] = 'main/update_location/$1';

// Deleting Data
$route['main/delete_project/(:num)'] = 'main/delete_project/$1';
$route['main/delete_location/(:num)'] = 'main/delete_location/$1';


