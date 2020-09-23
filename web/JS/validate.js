/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validate()
{
    var form = document.bookForm;
	if(form.subject.value==""){
		alert("Please enter subject name");
		return false;
	}
	else
		return true;
}
