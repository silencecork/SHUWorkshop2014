package com.example.bindserviceupdateprogress;

import com.example.bindserviceupdateprogress.RemoteCallback;

interface IUpdateService {

	void startExecute(in int max);
	
	void registerCallback(in RemoteCallback callback);

}