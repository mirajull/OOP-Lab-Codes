#include<iostream>
#include<string.h>
using namespace std;

class Transaction{
    private:
        int fromBankAccountNo;
        int toBankAccountNo;
        double transactionAmount;
    public:
        Transaction(){
			;
        }
        void set(int a,int b,double x)
        {
        	fromBankAccountNo=a;
        	toBankAccountNo=b;
        	transactionAmount=x;
		}
		void print()
		{
			cout<<"Transaction From "<<fromBankAccountNo<<" To "<<toBankAccountNo<<" Amount "<<transactionAmount<<endl;
		}
		
		
};

class Client{
    private:
        int bankAccountNo;
        char* name;
        Transaction transactions[20];
        int transactionNo;
        double balance;

    public:
        Client(){
        	transactionNo=0;
        }
		Client(int a,char*c,double b)
		{
			bankAccountNo=a;
			balance=b;
			name=new char[strlen(c)+1];
			strcpy(name,c);
		}
		
		void transaction(int a,int b,double c)
		{
			
			(transactions+transactionNo)->set(a,b,c);
			
			transactionNo++;
		}
		int getNo()
		{
			return  bankAccountNo;
		}
		double getBalance()
		{
			return  balance;
		}
		char * getName()
		{
			return  name;
		}
		void balance1(double a)
		{
			
			balance-=a;
		}
		void balance2(double a)
		{
			balance+=a;
		}
		
		void  setClient(Client a)
		{
			bankAccountNo=a.bankAccountNo;
			balance=a.balance;
			name=new char[strlen(a.name)+1];
			strcpy(name,a.name);
	 	} 
        void printClientInfo(){
            cout<<"--------------"<<endl;
            ///Do nessary things to print client info and transactions entries
            cout<<bankAccountNo<<' '<<name<<' '<<balance<<endl;
            int i=0;
            while(i<transactionNo)
            {
            	(transactions+i)->print();
            	i++;
			}
            cout<<"--------------"<<endl;
        }
        

};

class Bank{

    private:

        int maxCapacity;
        int numberOfClients;
        Client *clients;

    public:
    	
		Bank(int a)
		{
			clients=new Client [1+a];
			maxCapacity=a;
			numberOfClients=0;
		}
		bool findid(int i)
		{
			int j=0;
			while(j<numberOfClients)
			{
				if((clients+j)->getNo()==i) return true;
				j++;
			}
			return false;
		}
		void addClient(Client a)
		{
			if(numberOfClients==maxCapacity) 
			{
				cout<<"Error.Maximum Capacity reached"<<endl;
				return;
			}
			else if(findid(a.getNo())==1) 
			{
				cout<<"Account id "<<a.getNo()<<" already exists"<<endl;
				return;
			}
			(clients+numberOfClients)->setClient(a);
			numberOfClients++;
		}
		bool removeClient(int id)
		{
			if(findid(id)==false) 
			{
				cout<<"Id not found!!"<<endl;
				return false;
			}
			int j=0;
			while(j<numberOfClients)
			{
				if((clients+j)->getNo()==id)
				{
					while(j<numberOfClients-1)
					{
						(clients+j)->setClient(*(clients+j+1));
						j++;
						
					}
					numberOfClients--;
					return true;
				}
				j++;
			}
			
		}
		bool removeClient(Client a)
		{
			if(removeClient(a.getNo())) return true;
			return false;
		}
		bool makeTransaction(int from,int to,double amount)
		{
			if(findid(from)==false || findid(to)==false)
			{
				cout<<"Enter Valid account no"<<endl;
				return false;
			}
			else if(from==to)
			{
				cout<<"Same account"<<endl;
				return false;
			}
			int j=0;
			while(j<numberOfClients)
			{
				if((clients+j)->getNo()==from) 
				{
					if((clients+j)->getBalance()<amount)
					{
						cout<<"not enough balance"<<endl;
						return false;
					}
					(clients+j)->transaction(from,to,amount);
					(clients+j)->balance1(amount);
					while(j<numberOfClients)
					{
						if((clients+j)->getNo()==to)
						{
							(clients+j)->transaction(from,to,amount);
							(clients+j)->balance2(amount);
							return true;
						}
						j++;
					}
					
					
				}
				j++;
			}
			
		}
		

        void printClients(){
                cout<<endl;
                    ///call print function for each clients from here
                    int i=0;
                    while(i<numberOfClients)
                    {
                    	(clients+i)->printClientInfo();
                    	i++;
					}
                cout<<endl;
        }


};


int main(){


    Bank sonaliBank(3); ///Create Bank object with capacity 3. allocate memory for this clients.

    Client anik(1,"Anik Ahmed",5000); ///Create appropriate constructor for creating object
    Client azad(2,"Abul kalam Azad",5000);
    Client azad2(2,"Abul kalam Azad2",5000);
    Client tanvir(3,"Tanvir Hossain",5000);
    Client anonto(4,"Anonto Ghosh",5000);
    Client minhaz(5,"Minhazul Rahman",5000);
    Client sakib(6,"Sakib Khan",5000);


    ///addClient function will add an object to clients return true if successful otherwise
    ///If capacity reached show appropriate message return false
    ///if same account already exists show message return false

    sonaliBank.addClient(anik);
    sonaliBank.addClient(azad);
    sonaliBank.addClient(azad2);
    sonaliBank.addClient(tanvir);
    sonaliBank.addClient(anonto);
    sonaliBank.addClient(minhaz);
    sonaliBank.addClient(sakib);

    cout<<"After adding"<<endl;
    sonaliBank.printClients();  ///print detail information of clients


    ///remove client with bankaccountno
    ///if that account exists remove it return true else return false

    sonaliBank.removeClient(3);

    ///if that object exists. you can think of it as if this person's id is already exists like previous
    sonaliBank.removeClient(anonto);

    cout<<"After Removing"<<endl;
    sonaliBank.printClients();

    sonaliBank.addClient(minhaz);
    sonaliBank.addClient(sakib);
    cout<<"After Adding new clients"<<endl;
    sonaliBank.printClients();


    ///Make transaction will transfer money from fromAccount to toAccount
    ///if anyone of the id is invalid i mean not exists in list clients return false
    ///if fromAccount balance is less than amount no transation can be made return false
    ///if same account no given return false
    ///otherwise makeTransaction and put an entry into transactions

    sonaliBank.makeTransaction(1,1,2000);
    sonaliBank.makeTransaction(1,2,10000);
    sonaliBank.makeTransaction(1,2,3000);
    sonaliBank.makeTransaction(2,5,3000);
    sonaliBank.makeTransaction(1,5,3000);
    sonaliBank.makeTransaction(5,3,3000);

    sonaliBank.printClients();


    return 0;
}
