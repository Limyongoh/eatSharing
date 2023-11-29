import {Route,Routes} from 'react-router-dom'
import './css/Index.css';

//import Main from 'main/Main_index';
import Main from './main/Main_index';
import Content from 'main/content/Content';


function App() {
    return (
        <Routes>
            <Route path='/' element={<Main />} />
            <Route path='/content' element={<Content />}/>
        </Routes>
      );
}

export default App;