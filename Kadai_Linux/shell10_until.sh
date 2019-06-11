cnt=1
tmp=$1
tmp=$((tmp+1))
until [ $cnt -eq $tmp ]
do
        echo "値は $cnt です"
        let cnt++
done