#include<iostream>
#include<stdlib.h>
#include<string.h>

using namespace std;


///Do not change private variable to public
///Implement appropriate method to get and set values
class Book{
    private:
        int bookId;
        char *name;
        int price;
    public:
    	Book()
    	{
    		bookId=0;
    		price=0;
    		
		}
    	Book(int i,char *a,int p)
    	{
    		name=new char[strlen(a)+1];
    		strcpy(name,a);
    		bookId=i;
    		price=p;
		}
		
		int getbookId()
		{
			return bookId;
		}
		int getprice()
		{
			return price;
		}
		char* getname()
		{
			return name;
		}
		void set(int a,int b,char *c)
		{
			bookId=a;
			price=b;
			name=new char[1+strlen(c)];
			strcpy(name,c);
		}
};


class Library{
    private:
        int totalBooks;
        int bookCapacity;
        Book *books;

    public:
		Library(int a)
		{
			totalBooks=0;
			bookCapacity=a;
			books=new Book[1+bookCapacity];
		}
        void printLibrary(){
            cout<<"-----------"<<endl;
            int i=0;
            while(i<totalBooks)
            {
            	cout<<(books+i)->getbookId()<<". "<<(books+i)->getname()<<" "<<(books+i)->getprice()<<endl;
				i++;
			}
            cout<<"-----------"<<endl;
        }
        bool addBooks(Book x)
        {
        	if(totalBooks==bookCapacity) 
        	{
        		cout<<"Error"<<endl;
        		return false;
			}
		
        	(books+totalBooks)->set(x.getbookId(),x.getprice(),x.getname());
        	totalBooks++;
        	return true;
		}
		bool addBooks(Book x[],int y)
		{
			int i=0;
			while(i<y)
			{
			addBooks(x[i]);i++;
		}
			
		}
		int findTotalPriceOfBooks(int j)
		{
			int i=0;
			int ans=0;
			while(i<totalBooks)
			{
			int k=(books+i)->getbookId();
				if(k==j)
				{
					int p=(books+i)->getprice();
					ans+=p;	
				}
				i++;
			}
			
		return ans;
		}
		int sellBooks(int j)
		{
			int i=0;
			int ans=0;
			while(i<totalBooks)
			{
			int k1=(books+i)->getbookId();
				if(k1==j)
				{
					int p=(books+i)->getprice();
					ans+=p;
					int k=i;
					while(k<totalBooks-1)
					{
						(books+k)->set((books+k+1)->getbookId(),(books+k+1)->getprice(),(books+k+1)->getname());
						k++;
					}	
					totalBooks--;i--;
				}
				i++;
			}
			return ans;
		}
		int getCapacity()
		{
			return bookCapacity;
		}
		int expandCapacity(int money)
		{
			bookCapacity+=(money/50);
			return bookCapacity;
		}
		bool borrowBooks(int j,int n)
		{
			int i=0;
			int x=0;
			while(i<totalBooks)
			{
			int k1=(books+i)->getbookId();
				if(k1==j &x<n)
				{
					
					x++;
					int k=i;
					while(k<totalBooks-1)
					{
						(books+k)->set((books+k+1)->getbookId(),(books+k+1)->getprice(),(books+k+1)->getname());
						k++;
					}	
					totalBooks--;i--;
				}
				if(x==n)
				{
					return true;
				}
				i++;
			}
			return false;
		}
		

};

///Do not change any line of main function
int main(){

    Library lib(6);  ///6 is the capacity of books

    Book tarzan(1,"The new adventure of Tarzan",150);
    Book tarzan2(1,"The new adventure of Tarzan",350);
    Book homes(2,"The new adventure of Sherlock Holmes",100);
    Book lostWorld(3,"The Lost World",170);
    Book nonteFonte(4,"Nonte Fonte",80);
    Book pandobGoyenda(5,"pandob Goenda",100);
    Book feluda1(6,"Feluda 1",70);
    Book feluda2(6,"Feluda 2",70);
    Book tinGoyenda1(7,"TinGoenda 1",60);
    Book tinGoyenda2(7,"TinGoenda 2",60);
    Book tinGoyenda3(7,"TinGoenda 3",60);
    Book tinGoyenda4(7,"TinGoenda 4",60);


    ///add a new book to the library
    ///if overflow the capacity return false showing error message
    ///if successfull return true

    lib.addBooks(tarzan);
    lib.addBooks(tarzan2);
    lib.addBooks(homes);
    lib.addBooks(lostWorld);
    lib.addBooks(nonteFonte);
    lib.addBooks(pandobGoyenda);
    lib.addBooks(feluda1);

    lib.printLibrary();


    cout<<"Total Price of Books id 1 is "<<lib.findTotalPriceOfBooks(1)<<endl;///return find the total price of books with id

    int money=lib.sellBooks(1);                                    ///remove all books with the given id  return total price
    cout<<"Books of id 1 sold to price "<<money<<endl;

    cout<<"Total Price of Books id 1 is now "<<lib.findTotalPriceOfBooks(1)<<endl;

    cout<<"Previous capactiy was "<<lib.getCapacity()<<endl;        ///return book capacity

    cout<<"Expanded capacity now  "<<lib.expandCapacity(500)<<endl;
     ///for 50 taka 1 capacity can be increased
    ///so for 1000 taka the capacity will now be previous capacity+20


    lib.addBooks(feluda2);
    lib.addBooks(tinGoyenda1);
    lib.addBooks(tinGoyenda2);
    lib.addBooks(tinGoyenda3);
    lib.addBooks(tinGoyenda4);

    lib.printLibrary();         ///print all book information
    lib.borrowBooks(7,2);       ///remove 2 books with id 7. if there is not enough books return false with no change in books
    lib.printLibrary();

    Book *jaforIqbal=new Book[3];
    jaforIqbal[0]=Book(8,"Trinity",80);
    jaforIqbal[1]=Book(8,"Hat kata robin",100);
    jaforIqbal[2]=Book(8,"Ruhan",90);

    lib.addBooks(jaforIqbal,3); ///add first 3 books from this array to books in library. return how many successfully you have inserted
    lib.printLibrary();


    return 0;
}
