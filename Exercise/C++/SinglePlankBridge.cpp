#include <iostream>
#include <algorithm>

using namespace std;

int minStep(int L, int S, int T, int count, int* stone)
{
	int min = 0;
	if (S == T)
	{
		for (int i = 0; i < count; i++)
		{
			if (stone[i] % S == 0)
			{
				min++;
			}
		}

		return min;
	}
	
	int* bridge = new int[L+1];
	memset(bridge, 0, sizeof(int)*(L+1));
	
	int* num = new int[L+1];
	memset(num, -1, sizeof(int)*(L+1));

	sort(stone, stone + count);

	if (stone[0] > 90)
	{
		int k = stone[0] - 90;
		for (int i = 0; i < count; i++)
		{
			stone[i] -= k;
		}

		L -= k;
	}

	for (int i = 1; i < count; i++)
	{
		int k = stone[i] - stone[i - 1];
		if (k > 90)
		{
			for (int j = i; j < count; j++)
			{
				stone[j] -= k;
			}
			L -= k;
		}
	}

	for (int i = 0; i < count; i++)
	{
		bridge[stone[i]] = 1;
	}

	num[0] = 0;
	for (int i = S; i < L + T; i++)
	{
		min = 101;
		for (int j = i - T; j <= i - S; j++)
		{
			if (j >= 0 && num[j] != -1 && num[j] < min)
			{
				min = num[j];
			}
		}

		if (min != 101)
		{
			num[i] = min + bridge[i];
		}
	}

	min = 101;
	for (int i = L; i < stone[count] + T; i++)
	{
		if (i >= 0 && num[i] != -1 && num[i] < min)
		{
			min = num[i];
		}
	}

	cout << min << endl;
}

//int main()
//{
//	int arr[5] = {4, 3, 0, 8, 2};
//	sort(arr, arr + 5);
//	for (int i = 0; i < 5; i++)
//	{
//		cout << arr[i] << " ";
//	}
//	cout << endl;
//}