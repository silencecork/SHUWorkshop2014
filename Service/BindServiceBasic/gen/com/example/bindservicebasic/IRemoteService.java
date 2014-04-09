/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\Dropbox\\Dropbox\\�@�s�ҵ{\\2014.04.12\\Service\\SimpleBindService\\src\\com\\example\\bindservicebasic\\IRemoteService.aidl
 */
package com.example.bindservicebasic;
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.bindservicebasic.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.example.bindservicebasic.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.bindservicebasic.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.example.bindservicebasic.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.bindservicebasic.IRemoteService))) {
return ((com.example.bindservicebasic.IRemoteService)iin);
}
return new com.example.bindservicebasic.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_passValue:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.passValue(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.bindservicebasic.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void passValue(java.lang.String val) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(val);
mRemote.transact(Stub.TRANSACTION_passValue, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_passValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void passValue(java.lang.String val) throws android.os.RemoteException;
}
