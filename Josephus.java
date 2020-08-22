/*
 * 作者：BUPT小萌妹
 * 
 * 题目：约瑟夫问题。
 * 题目描述：约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，
 * 最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3。
 * 
 * 题目扩展：可以增添变量startNum，游戏规则相近但更难，规则是：人数为number，开始
 * 报数的人的序号是startNum，报数gameNum个数之后将停留在的序号上的人排除，以此类推。
 * 
 * 解决思路：运用链表解决问题。
 */


package com.Josephus;

public class Josephus {

	public static void main(String[] args) {
		CreateLink link=new CreateLink();
		link.setNumber(6);//设置6个人
		link.setN(1);//开始报数的人序号是1
		link.setM(5);//报数个数是5
		link.SetLink();//建立链表
		link.show();//展示
		link.play();//开始运行
		link.show();//展示
	}

	
}



//设置人类
class Human
{
	int no;//这个人的序号
	Human nextHuman=null;//设置这个人序号后的下一个人
	//建立构造函数将Human进行初始化
	public Human(int no)
	{
		this.no=no;//设置序号
	}
}



//定义一个建立链表类，包含设置出的Human
class CreateLink
{
	Human FirstHuman=null;//设置序号为最开始的FirstHuman
	Human temp;//temp用来临时使用
	
	int number;//设置总共的人数
	int startNum;//设置开始计数的人的序号N
	int gameNum;//设置游戏中的M
	
	
	
	//设置链表的长度number
	public void setNumber(int number)
	{
		this.number=number;
	}
	//设置startNum，也就是N的值
	public void setN(int N)
	{
		this.startNum=N;
	}
	//设置gameNum，也就是M的值
	public void setM(int M)
	{
		this.gameNum=M;
	}
	
	
	
	//构造一个函数将所有的Huamn连接起来
	public void SetLink()
	{
		for(int i=1;i<=number;i++)//进行次数为number次的循环，所有的就都被连接了
		{
			if(i==1)//如果是第一个位置，就把他设置为FirstHuman
			{
				Human people=new Human(i);
				this.FirstHuman=people;
				this.temp=people;
			}
			else
			{
				if(i<number)//如果是2~number-1的位置，就将他们依次连接
				{
					Human people=new Human(i);
					temp.nextHuman=people;
					temp=people;
				}
				else//如果是最后一个，就把他的nextHuamn设置为FirstHuman
				{
					Human people=new Human(i);
					temp.nextHuman=people;
					temp=people;
					temp.nextHuman=this.FirstHuman;
				}
			}
		}
	}
	
	
	
	//游戏开始的函数
	public void play()
	{
		//首先要找到开始计数的人的序号，进行for循环遍历
		this.temp=this.FirstHuman;
		for(int i=1;i<this.startNum;i++)//循环次数是N-1
		{
			this.temp=this.temp.nextHuman;
		}
		do {
			//开始进行M计数，找到排出的人的序号
			for(int j=1;j<this.gameNum;j++)//循环次数是M-1
			{
				this.temp=this.temp.nextHuman;
			}
			System.out.println("要被排除在外的序号是"+temp.no);
			//将这个序号排除在外，即越过这个结点连起链表
			Human temp1=temp;
			while(temp.nextHuman!=temp1)
			{
				temp=temp.nextHuman;
			}
			temp.nextHuman=temp1.nextHuman;
			temp=temp.nextHuman;
			this.number--;//如果剩下Human的数目大于1则继续
		}while(this.number!=1);
	}
	
	
	
	//构造一个函数打印整个链表
	public void show()
	{
		Human people= this.FirstHuman;
		do 
		{
			System.out.println(people.no);
			people=people.nextHuman;
		}while(people!=this.FirstHuman);
	}
}