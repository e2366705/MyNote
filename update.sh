echo '(=^_^=)  Auto Updata Code...  (=^_^=) '
echo 'input => ./update.sh toStart Updata Code...'

echo '------- step 1 ---------'
git rm -f --cached .
echo '------- step 2 ---------'
git add -f *
echo '------- step 3 ---------'
git commit -m 'Updata...'
echo '------- step 4 ---------'
git push -u origin master