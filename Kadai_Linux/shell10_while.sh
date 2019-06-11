i=1
while [[ $i -lt $1+1 ]]
do
  echo "値は = $i です"
  i=$((i+1))
done