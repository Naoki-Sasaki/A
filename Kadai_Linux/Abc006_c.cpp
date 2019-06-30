#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <iomanip>
#include <limits>
#include <list>
#include <queue>
#include <tuple>
#include <map>
using namespace std;


int main(void){
    int n;
    cin >> n;
    string a[n];

    int flag[n];

    string imp;
    for(int i = 0; i < n; i++){
        cin >> imp;
        a[i] = imp;
    }

    
    
    string tmp;
    for(int i = 0; i < n; i++){
        tmp = a[i];

        for(int j = i; j < n; j++){
            if(a[j] == tmp){

            }
        }
    }





    return 0;
}