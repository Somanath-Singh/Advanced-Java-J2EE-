function validate(frm){
	alert("client side form validation are done");
	//empty the existing error messages
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	document.getElementById("paddrsErr").innerHTML="";
	
	//change the hidden box value to "enabled" indicating whether client form validations are done
	frm.vstatus.value="enabled";
	
	//read the form data
	let name=frm.pname.value;
	let age=frm.page.value;
	let addrs=frm.paddrs.value;
	
	//write the client side form validations logics
	let vflag=true;
	
	if(name==""){//required rule on name
		document.getElementById("pnameErr").innerHTML="<b>person name is required</b>";
		vflag=false;
	}
	else if(name.length<5){//minlength rule on name
		document.getElementById("pnameErr").innerHTML="<b>person name should contain min of 5 letters </b>";
		vflag=false;
	}
	
	if(age==""){//required rule on age
		document.getElementById("pageErr").innerHTML="<b>person age is required</b>";
		vflag=false;
	}
	else if(isNaN(age)){//numeric rule on name
		document.getElementById("pageErr").innerHTML="<b>person age should be numeric value </b>";
		vflag=false;
	}
	else if(age<=0 || age>=126){//range rule on name
		document.getElementById("pageErr").innerHTML="<b>person age must be there 1 through 125 </b>";
		vflag=false;
	}
	
	if(addrs==""){//required rule on age
		document.getElementById("paddrsErr").innerHTML="<b>person addres is required</b>";
		vflag=false;
	}
	
	//alert(vflag);
	return vflag;
	
}