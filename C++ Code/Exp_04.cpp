#include<iostream>
using namespace std;
int main() {
	int n;
	cout << "请输入阶数：";
	cin >> n;
	int** a;
	a = new int* [n];
	for (int i = 0; i < n; i++) {
		a[i] = new int[n];
	}
	cout << "请输入矩阵" << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}
	int flag1 = 1;
	for (int i = 0; i < n; i++) {
		if (a[i][i] == 0) {
			flag1 = 0;
		}
	}//自反
	int flag2 = 1;
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j <= n - 1; j++) {
			if (a[i][j] == a[j][i] && a[i][j] == 1) {
				flag2 = 0;
			}
		}
	}//反对称 
	int** b;
	b = new int* [n];
	for (int i = 0; i < n; i++) {
		b[i] = new int[n];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			b[i][j] = 0;
		}
	}
	int flag3 = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			b[i][j] = 0;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				b[i][j] = b[i][j] + a[i][k] * a[k][j];
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (b[i][j] > 0 && a[i][j] == 0) {
				flag3 = 0;
			}
		}
	}//传递性

	if (flag1 && flag2 && flag3)cout << "偏序" << endl;
	else cout << "非偏序" << endl;
	//for(int i=0;i<n;i++){
		//for(int j=0;j<n;j++){
		//	cout<<b[i][j]<<" ";
		//	if(j==n-1)cout<<endl;
	//	}
//	}
	int* c = new int[n];
	int* d = new int[n];
	for (int i = 0; i < n; i++) {
		c[i] = 1; d[i] = 1;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j] == 1 && i != j) {
				c[j] = 0; d[i] = 0;
			}
		}
	}
	cout << "极小元：";
	for (int i = 0; i < n; i++) {
		if (c[i])cout << i << " ";
	}
	cout << endl;//输出极小元

	cout << "极大元：";
	for (int i = 0; i < n; i++) {
		if (d[i])cout << i << " ";
	}
	cout << endl;//输出极大元
	int sum1 = 0; int r1 = 0;
	for (int i = 0; i < n; i++) {
		if (c[i]) {
			sum1++;
			r1 = i;
		}
	}
	if (sum1 > 1)cout << "无最小元" << endl;
	else if (sum1 == 1)cout << r1 << endl;//输出最小元 
	int sum2 = 0; int r2 = 0;
	for (int i = 0; i < n; i++) {
		if (d[i]) {
			sum2++;
			r2 = i;
		}
	}
	if (sum2 > 1)cout << "无最大元" << endl;
	else if (sum2 == 1)cout << r2 << endl;//输出最大元 
}




